package org.apache.vaadin.ui.layout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Layout;

/**
 * Created by tringuyen on 10/17/16.
 */
public interface LayoutPartialUI {
    Layout draw(VaadinRequest vaadinRequest);
}
