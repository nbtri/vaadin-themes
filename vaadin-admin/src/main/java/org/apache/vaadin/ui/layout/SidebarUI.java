package org.apache.vaadin.ui.layout;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;
import org.apache.vaadin.admin.ui.helper.AdminUIDefaultConfiguration;

/**
 * Created by tringuyen on 10/17/16.
 */
public class SidebarUI implements LayoutPartialUI {
    @Override
    public Layout draw(VaadinRequest vaadinRequest) {
        VerticalLayout sidebar = new VerticalLayout();
        sidebar.setWidth(AdminUIDefaultConfiguration.DEFAULT_SIDEBAR_WIDTH);

        sidebar.addComponent(buildLink("Manage users", "/admin/ui/users", "_blank"));
        sidebar.addComponent(buildLink("Manage RFOs", "/admin/ui/rfos", "_blank"));

        return sidebar;
    }

    protected Link buildLink(String label, String href, String target) {
        Link link = new Link(label,
                new ExternalResource(href));
        link.setTargetName(target);

        return link;
    }
}
