package org.apache.vaadin.ui.layout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by tringuyen on 10/17/16.
 */
public abstract class AdminLayoutUI extends UI {

    protected HeaderUI headerUI = new HeaderUI();
    protected FooterUI footerUI = new FooterUI();
    protected SidebarUI sidebarUI = new SidebarUI();

    protected abstract VerticalLayout drawMainLayout(VaadinRequest vaadinRequest);

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();

        HorizontalLayout body = new HorizontalLayout();

        Layout sidebar = sidebarUI.draw(request);
        Layout main = drawMainLayout(request);
        body.addComponents(sidebar, main);
        body.setExpandRatio(sidebar, 0.3f);
        body.setExpandRatio(main, 0.7f);

        Layout header = headerUI.draw(request);
        Layout footer = footerUI.draw(request);

        content.addComponents(header, body, footer);

        content.setMargin(true);
        content.setSpacing(true);

        setContent(content);
    }

    @Override
    public String getStyleName() {
        return ValoTheme.LAYOUT_COMPONENT_GROUP;
    }
}
