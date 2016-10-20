package org.apache.vaadin.ui.view;

import com.jensjansson.pagedtable.PagedTable;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.apache.vaadin.ui.CustomerDatasource;
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

        table = createLazyTable();
        HorizontalLayout tableControls = table.createControls();
        mainContent.addComponent(table);
        mainContent.addComponent(tableControls);
        mainContent.setExpandRatio(table, 1f);
        mainContent.setExpandRatio(tableControls, 1f);
        mainContent.setComponentAlignment(tableControls, Alignment.TOP_CENTER);

        addBodyContent(mainContent, 0.7f);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Welcome Simple Grid View");
    }

    public PagedTable createLazyTable() {
        PagedTable pagedTable = new PagedTable("Customers");
        CustomerDatasource container = new CustomerDatasource(Customer.class);
        pagedTable.setContainerDataSource(container);
        pagedTable.setPageLength(10);
        pagedTable.setImmediate(true);
        pagedTable.setSelectable(true);
        pagedTable.setAlwaysRecalculateColumnWidths(true);
        pagedTable.setWidth("1000px");
        return pagedTable;
    }
}
