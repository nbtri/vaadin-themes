package org.apache.vaadin.ui.layout;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.vaadin.admin.ui.helper.AdminUIDefaultConfiguration;

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

//        CssLayout group = new CssLayout();
//        group.addComponents(loggedUser, logoutLink);
//        group.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

//        header.addComponent(group);

        return header;
    }
}
