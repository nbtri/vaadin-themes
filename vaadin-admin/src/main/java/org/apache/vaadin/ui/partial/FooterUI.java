package org.apache.vaadin.ui.partial;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Layout;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by tringuyen on 10/17/16.
 */
public class FooterUI implements LayoutPartialUI {

    FooterDesign footerDesign = new FooterDesign();

    @Override
    public Layout draw(VaadinRequest vaadinRequest) {
        return footerDesign;
    }

    @Override
    public Layout draw(VaadinRequest vaadinRequest, Navigator navigator) {
        throw new NotImplementedException();
    }

    @Override
    public Layout draw(Navigator navigator) {
        throw new NotImplementedException();
    }
}
