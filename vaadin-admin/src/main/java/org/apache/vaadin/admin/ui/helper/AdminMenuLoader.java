package org.apache.vaadin.admin.ui.helper;

import com.sun.media.jfxmedia.logging.Logger;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
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
    public static void loadMenu(Layout layout, Navigator navigator) {
        try {
            JSONObject json = loadFile();

            JSONObject menu = (JSONObject) json.get("menu");

            JSONArray items = (JSONArray) menu.get("items");
            items.stream().forEach(item -> {
                JSONObject menuItem = (JSONObject) item;
                buildLink(menuItem, layout, navigator);
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

    private static void buildLink(JSONObject menuItem, Layout container, Navigator navigator) {
        final int EXTERNAL_LINK = 1;
        final int NAVIGATOR_VIEW = 0;

        int type = menuItem.containsKey("href") ? 1 : 0;

        switch (type) {
            case EXTERNAL_LINK:
                String label = getText(menuItem, "text", "");
                String href = getText(menuItem, "href", "");
                String target = getText(menuItem, "target", "_blank");
                Link link = buildLink(label, href, target);
                container.addComponent(link);
                break;
            case NAVIGATOR_VIEW:
                final String viewName = getText(menuItem, "viewName", "");
                Button button = new Button(viewName);
                button.setStyleName("link");
                button.addClickListener(event -> {
                    navigator.navigateTo(viewName);
                });
                break;

        }
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
