package org.apache.vaadin.admin.ui.partial;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.apache.vaadin.admin.ui.helper.AdminMenuLoader;
import org.apache.vaadin.admin.ui.helper.AdminUIDefaultConfiguration;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by tringuyen on 10/17/16.
 */
public class SidebarUI implements LayoutPartialUI {
    @Override
    public Layout draw(VaadinRequest vaadinRequest) {
        throw new NotImplementedException();
    }

    @Override
    public Layout draw(VaadinRequest vaadinRequest, Navigator navigator) {
        VerticalLayout sidebar = new VerticalLayout();
        sidebar.setWidth(AdminUIDefaultConfiguration.DEFAULT_SIDEBAR_WIDTH);
        AdminMenuLoader.loadMenu(sidebar, navigator);

        return sidebar;
    }
}
