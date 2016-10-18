package org.apache.vaadin.admin.ui.helper;

import com.sun.media.jfxmedia.logging.Logger;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Link;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Created by tringuyen on 10/17/16.
 */
public class AdminMenuLoader {
    public static void loadMenu(Layout layout) {
        try {
            JSONObject json = loadFile();

            JSONObject menu = (JSONObject) json.get("menu");

            JSONArray items = (JSONArray) menu.get("items");
            items.stream().forEach(item -> {
                JSONObject menuItem = (JSONObject) item;
                layout.addComponent(buildLink(getText(menuItem, "text", ""),
                        getText(menuItem, "href", ""),
                        getText(menu, "target", "_blank")));
            });
        } catch (IOException e) {
            Logger.logMsg(Logger.WARNING, "Cannot find menu.json file.");
        } catch (ParseException e) {
            Logger.logMsg(Logger.ERROR, "Cannot parse menu.json file");
        }
    }

    private static JSONObject loadFile() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        URL url = AdminMenuLoader.class.getResource("menu.json");
        Object obj = parser.parse(new FileReader(url.getPath()));

        return (JSONObject) obj;
    }

    private static Link buildLink(String label, String href, String target) {
        Link link = new Link(label,
                new ExternalResource(href));
        link.setTargetName(target);

        return link;
    }

    private static String getText(JSONObject jsonObject, String key, String ifnull) {
        if(jsonObject.containsKey(key)) {
            return (String) jsonObject.get(key);
        } else {
            return ifnull;
        }
    }
}
