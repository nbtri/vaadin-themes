package org.apache.vaadin.admin.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by tringuyen on 10/18/16.
 */
public class SimpleGridView extends VerticalLayout implements View {

    public SimpleGridView() {
        setSizeFull();

        Label title = new Label("Simple Grid view");
        addComponent(title);
        setComponentAlignment(title, Alignment.TOP_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome Simple Grid View");
    }
}
