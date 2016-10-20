package org.apache.vaadin.ui.partial;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.apache.vaadin.ui.helper.AdminUIDefaultConfiguration;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by tringuyen on 10/17/16.
 */
public class HeaderUI implements LayoutPartialUI {
    @Override
    public Layout draw(VaadinRequest vaadinRequest) {
        HorizontalLayout header = new HorizontalLayout();
        header.setWidth(AdminUIDefaultConfiguration.DEFAULT_SIDEBAR_WIDTH);

        Label loggedUser = new Label("Welcome User");
        loggedUser.setWidthUndefined();
        header.addComponent(loggedUser);
        header.setComponentAlignment(loggedUser, Alignment.TOP_LEFT);

        Link logoutLink = new Link("Logout", new ExternalResource("/admin/logout"));
        logoutLink.setWidthUndefined();
        header.addComponent(logoutLink);
        header.setComponentAlignment(logoutLink, Alignment.TOP_LEFT);

        return header;
    }

    @Override
    public Layout draw(VaadinRequest vaadinRequest, Navigator navigator) {
        throw new NotImplementedException();
    }

    @Override
    public Layout draw(Navigator navigator) {
        throw new NotImplementedException();
    }
}
