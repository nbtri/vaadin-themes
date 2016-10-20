package org.apache.vaadin.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import org.apache.vaadin.ui.NavigatorUIContainer;
import org.apache.vaadin.ui.helper.DefinedView;
import org.apache.vaadin.ui.layout.MasterLayoutUI;

/**
 * Created by tringuyen on 10/18/16.
 */
@DefinedView(viewName = "gridView", clazz = SimpleGridView.class)
public class SimpleGridView extends MasterLayoutUI implements View {

    public SimpleGridView(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        super(container, vaadinRequest);
    }

    @Override
    protected void init(NavigatorUIContainer container, VaadinRequest vaadinRequest) {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome Simple Grid View");
    }
}
