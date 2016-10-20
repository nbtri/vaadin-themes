package org.apache.vaadin.ui.layout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.apache.vaadin.ui.NavigatorUIContainer;
import org.apache.vaadin.ui.partial.FooterUI;
import org.apache.vaadin.ui.partial.HeaderUI;
import org.apache.vaadin.ui.partial.SidebarUI;

/**
 * Created by tringuyen on 10/17/16.
 */
public abstract class MasterLayoutUI extends VerticalLayout {

    protected HeaderUI headerUI;
    protected FooterUI footerUI;
    protected SidebarUI sidebarUI;
    protected HorizontalLayout body;

    public MasterLayoutUI(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        headerUI = new HeaderUI();
        sidebarUI = new SidebarUI();
        footerUI = new FooterUI();

        body = new HorizontalLayout();
        body.setSizeFull();

        Layout sidebar = sidebarUI.draw(vaadinRequest, container.getNavigator());

        body.addComponents(sidebar);
        body.setExpandRatio(sidebar, 0.3f);

        Layout header = headerUI.draw(vaadinRequest);
        Layout footer = footerUI.draw(vaadinRequest);

        addComponents(header, body, footer);

        setExpandRatio(header, 1f);
        setExpandRatio(footer, 1f);
        setExpandRatio(body, 1f);

        setMargin(true);
        setSpacing(true);

        init(container, vaadinRequest);
    }

    protected void addBodyContent(Component component, float ratio) {
        body.addComponent(component);
        body.setExpandRatio(component, ratio);
    }

    protected abstract void init(NavigatorUIContainer container, VaadinRequest vaadinRequest);

    @Override
    public String getStyleName() {
        return ValoTheme.LAYOUT_COMPONENT_GROUP;
    }
}
