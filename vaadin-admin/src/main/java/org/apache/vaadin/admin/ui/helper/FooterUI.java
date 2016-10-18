package org.apache.vaadin.admin.ui.helper;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.apache.vaadin.admin.ui.partials.FooterDesign;

/**
 * Created by tringuyen on 10/17/16.
 */
public class FooterUI implements LayoutPartialUI {

    FooterDesign footerDesign = new FooterDesign();

    @Override
    public Layout draw(VaadinRequest vaadinRequest) {
        return footerDesign;
    }
}
