package org.apache.vaadin.ui.view;

import com.jensjansson.pagedtable.PagedTable;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.apache.vaadin.ui.CustomerContainer;
import org.apache.vaadin.ui.NavigatorUIContainer;
import org.apache.vaadin.ui.helper.DefinedView;
import org.apache.vaadin.ui.layout.MasterLayoutUI;
import org.apache.vaadin.ui.model.Customer;

/**
 * Created by tringuyen on 10/18/16.
 */
@DefinedView(viewName = "gridView", clazz = SimpleGridView.class)
public class SimpleGridView extends MasterLayoutUI implements View {

    private PagedTable table;
    private VerticalLayout mainContent;

    public SimpleGridView(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        super(container, vaadinRequest);
    }

    @Override
    protected void init(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        mainContent = new VerticalLayout();

        createLazyTable();

        addBodyContent(mainContent, 0.7f);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome Simple Grid View");
    }

    public void createLazyTable() {
        table = new PagedTable("Customers");
        HorizontalLayout tableControls = table.createControls();
        CustomerContainer container = new CustomerContainer(Customer.class);
        table.setPageLength(10);
        table.setContainerDataSource(container);
        table.setImmediate(true);
        table.setSelectable(true);
        table.setAlwaysRecalculateColumnWidths(true);

        mainContent.addComponent(table);
        mainContent.addComponent(tableControls);
        mainContent.setExpandRatio(table, 1f);
        mainContent.setExpandRatio(tableControls, 1f);
        mainContent.setComponentAlignment(tableControls, Alignment.TOP_CENTER);
    }
}
