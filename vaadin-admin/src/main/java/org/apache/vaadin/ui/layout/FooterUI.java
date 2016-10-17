package org.apache.vaadin.ui.layout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by tringuyen on 10/17/16.
 */
public class FooterUI implements LayoutPartialUI {
    @Override
    public Layout draw(VaadinRequest vaadinRequest) {
        VerticalLayout footer = new VerticalLayout();
        footer.setWidth("100%");

        Label footerText = new Label("Globaltrade.net");
        footerText.setWidthUndefined();

        footer.addComponent(footerText);
        footer.setComponentAlignment(footerText, Alignment.MIDDLE_CENTER);

        return footer;
    }
}
