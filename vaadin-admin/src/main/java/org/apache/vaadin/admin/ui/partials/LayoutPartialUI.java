package org.apache.vaadin.admin.ui.partials;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Layout;

/**
 * Created by tringuyen on 10/17/16.
 */
public interface LayoutPartialUI {
    Layout draw(VaadinRequest vaadinRequest);

    Layout draw(VaadinRequest vaadinRequest, Navigator navigator);
}
