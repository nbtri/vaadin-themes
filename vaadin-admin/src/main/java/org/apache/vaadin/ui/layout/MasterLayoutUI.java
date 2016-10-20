package org.apache.vaadin.ui.layout;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.vaadin.ui.NavigatorUIContainer;
import org.apache.vaadin.ui.partial.FooterUI;
import org.apache.vaadin.ui.partial.HeaderUI;
import org.apache.vaadin.ui.partial.SidebarUI;
import org.apache.vaadin.ui.view.SimpleGridView;

/**
 * Created by tringuyen on 10/17/16.
 */
public abstract class MasterLayoutUI extends VerticalLayout {

    protected HeaderUI headerUI = new HeaderUI();
    protected FooterUI footerUI = new FooterUI();
    protected SidebarUI sidebarUI = new SidebarUI();

    public MasterLayoutUI(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        headerUI = new HeaderUI();
        sidebarUI = new SidebarUI();
        footerUI = new FooterUI();

        HorizontalLayout body = new HorizontalLayout();

        Layout sidebar = sidebarUI.draw(vaadinRequest, container.getNavigator());

        body.addComponents(sidebar);
        body.setExpandRatio(sidebar, 0.3f);

        Layout header = headerUI.draw(vaadinRequest);
        Layout footer = footerUI.draw(vaadinRequest);

        addComponents(header, body, footer);

        setMargin(true);
        setSpacing(true);

        init(container, vaadinRequest);
    }

    protected abstract void init(NavigatorUIContainer container, VaadinRequest vaadinRequest);

    @Override
    public String getStyleName() {
        return ValoTheme.LAYOUT_COMPONENT_GROUP;
    }
}
