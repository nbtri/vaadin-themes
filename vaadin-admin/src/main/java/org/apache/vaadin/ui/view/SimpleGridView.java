package org.apache.vaadin.ui.view;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import org.apache.vaadin.ui.CustomerService;
import org.apache.vaadin.ui.NavigatorUIContainer;
import org.apache.vaadin.ui.helper.DefinedView;
import org.apache.vaadin.ui.layout.MasterLayoutUI;
import org.apache.vaadin.ui.model.Customer;

/**
 * Created by tringuyen on 10/18/16.
 */
@DefinedView(viewName = "gridView", clazz = SimpleGridView.class)
public class SimpleGridView extends MasterLayoutUI implements View {

    private Grid grid;
    private CustomerService service = CustomerService.getInstance();

    public SimpleGridView(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        super(container, vaadinRequest);
    }

    @Override
    protected void init(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        grid = new Grid();
        grid.setSizeFull();
        addBodyContent(grid, 0.7f);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome Simple Grid View");
        grid.setContainerDataSource(new BeanItemContainer<>(Customer.class, service.findAll()));
    }
}
