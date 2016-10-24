package org.apache.vaadin.ui.view;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.CustomTable.RowHeaderMode;
import org.apache.vaadin.ui.CustomerContainer;
import org.apache.vaadin.ui.CustomerStatus;
import org.apache.vaadin.ui.NavigatorUIContainer;
import org.apache.vaadin.ui.helper.DefinedView;
import org.apache.vaadin.ui.layout.MasterLayoutUI;
import org.apache.vaadin.ui.model.Customer;
import org.apache.vaadin.ui.table.filter.DemoFilterDecorator;
import org.apache.vaadin.ui.table.filter.DemoFilterGenerator;
import org.tepi.filtertable.FilterTable;
import org.tepi.filtertable.FilterTreeTable;
import org.tepi.filtertable.paged.PagedFilterControlConfig;
import org.tepi.filtertable.paged.PagedFilterTable;

/**
 * Created by tringuyen on 10/24/16.
 */
@DefinedView(viewName = "filterTableGridView", clazz = FilterTableGridView.class)
public class FilterTableGridView extends MasterLayoutUI implements View {

    private VerticalLayout mainContent;

    public FilterTableGridView(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        super(container, vaadinRequest);
    }

    @Override
    protected void init(NavigatorUIContainer container, VaadinRequest vaadinRequest) {
        mainContent = new VerticalLayout();
        mainContent.setMargin(new MarginInfo(true, false, false, false));
        mainContent.setSizeFull();

        CustomerContainer customerDS = new CustomerContainer(Customer.class);

        PagedFilterTable filterTable = new PagedFilterTable();
        filterTable.setSizeFull();
        filterTable.setFilterDecorator(new DemoFilterDecorator());
        filterTable.setFilterGenerator(new DemoFilterGenerator());

        filterTable.setFilterBarVisible(true);

        filterTable.setSelectable(true);
        filterTable.setImmediate(true);
        filterTable.setMultiSelect(true);

        filterTable.setRowHeaderMode(RowHeaderMode.INDEX);

        filterTable.setColumnCollapsingAllowed(true);

        filterTable.setColumnReorderingAllowed(true);

        filterTable.setContainerDataSource(customerDS);

        filterTable.setColumnCollapsed("status", true);

        filterTable.setItemDescriptionGenerator((source, itemId, propertyId) -> "Just testing ItemDescriptionGenerator");

//        filterTable.addValueChangeListener(event -> {
//
//        });

        mainContent.addComponent(filterTable);
        mainContent.addComponent(filterTable.createControls(new PagedFilterControlConfig()));
        mainContent.addComponent(buildButtons(filterTable));
        mainContent.setExpandRatio(filterTable, 1f);

        addBodyContent(mainContent, 0.7f);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Filter Table");
    }

    private Component buildButtons(final FilterTable relatedFilterTable) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setHeight(null);
        buttonLayout.setWidth("100%");
        buttonLayout.setSpacing(true);

        Label hideFilters = new Label("Show Filters:");
        hideFilters.setSizeUndefined();
        buttonLayout.addComponent(hideFilters);
        buttonLayout.setComponentAlignment(hideFilters, Alignment.MIDDLE_LEFT);

        for (Object propId : relatedFilterTable.getContainerPropertyIds()) {
            Component t = createToggle(relatedFilterTable, propId);
            buttonLayout.addComponent(t);
            buttonLayout.setComponentAlignment(t, Alignment.MIDDLE_LEFT);
        }

        CheckBox showFilters = new CheckBox("Toggle Filter Bar visibility");
        showFilters.setValue(relatedFilterTable.isFilterBarVisible());
        showFilters.setImmediate(true);
        showFilters.addValueChangeListener(event -> relatedFilterTable.setFilterBarVisible((Boolean) event
                .getProperty().getValue()));
        buttonLayout.addComponent(showFilters);
        buttonLayout.setComponentAlignment(showFilters, Alignment.MIDDLE_RIGHT);
        buttonLayout.setExpandRatio(showFilters, 1);

        CheckBox wrapFilters = new CheckBox("Wrap Filter Fields");
        wrapFilters.setValue(relatedFilterTable.isWrapFilters());
        wrapFilters.setImmediate(true);
        wrapFilters.addValueChangeListener(event -> relatedFilterTable.setWrapFilters((Boolean) event.getProperty()
                .getValue()));
        buttonLayout.addComponent(wrapFilters);
        buttonLayout.setComponentAlignment(wrapFilters, Alignment.MIDDLE_RIGHT);

        final Button runNow = new Button("Filter now");
        runNow.addClickListener(event -> relatedFilterTable.runFilters());

        CheckBox runOnDemand = new CheckBox("Filter lazily");
        runOnDemand.setValue(relatedFilterTable.isFilterOnDemand());
        runNow.setEnabled(relatedFilterTable.isFilterOnDemand());
        runOnDemand.setImmediate(true);
        runOnDemand.addValueChangeListener(event -> {
            boolean value = (Boolean) event.getProperty().getValue();
            relatedFilterTable.setFilterOnDemand(value);
            runNow.setEnabled(value);
        });
        buttonLayout.addComponent(runOnDemand);
        buttonLayout.setComponentAlignment(runOnDemand, Alignment.MIDDLE_RIGHT);
        buttonLayout.addComponent(runNow);

        Button setVal = new Button("Set the State filter to 'Customer'");
        setVal.addClickListener(event -> relatedFilterTable
                .setFilterFieldValue("state", CustomerStatus.Customer));
        buttonLayout.addComponent(setVal);

        Button reset = new Button("Reset");
        reset.addClickListener(event -> relatedFilterTable.resetFilters());
        buttonLayout.addComponent(reset);

        Button clear = new Button("Clear");
        clear.addClickListener(event -> relatedFilterTable.clearFilters());
        buttonLayout.addComponent(clear);

        return buttonLayout;
    }

    private Component buildButtons(final FilterTreeTable relatedFilterTable) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setHeight(null);
        buttonLayout.setWidth("100%");
        buttonLayout.setSpacing(true);

        Label hideFilters = new Label("Show Filters:");
        hideFilters.setSizeUndefined();
        buttonLayout.addComponent(hideFilters);
        buttonLayout.setComponentAlignment(hideFilters, Alignment.MIDDLE_LEFT);

        for (Object propId : relatedFilterTable.getContainerPropertyIds()) {
            Component t = createToggle(relatedFilterTable, propId);
            buttonLayout.addComponent(t);
            buttonLayout.setComponentAlignment(t, Alignment.MIDDLE_LEFT);
        }

        CheckBox showFilters = new CheckBox("Toggle Filter Bar visibility");
        showFilters.setValue(relatedFilterTable.isFilterBarVisible());
        showFilters.setImmediate(true);
        showFilters.addValueChangeListener(event -> relatedFilterTable.setFilterBarVisible((Boolean) event
                .getProperty().getValue()));
        buttonLayout.addComponent(showFilters);
        buttonLayout.setComponentAlignment(showFilters, Alignment.MIDDLE_RIGHT);
        buttonLayout.setExpandRatio(showFilters, 1);

        CheckBox wrapFilters = new CheckBox("Wrap Filter Fields");
        wrapFilters.setValue(relatedFilterTable.isWrapFilters());
        wrapFilters.setImmediate(true);
        wrapFilters.addValueChangeListener(event -> relatedFilterTable.setWrapFilters((Boolean) event.getProperty()
                .getValue()));
        buttonLayout.addComponent(wrapFilters);
        buttonLayout.setComponentAlignment(wrapFilters, Alignment.MIDDLE_RIGHT);

        final Button runNow = new Button("Filter now");
        runNow.addClickListener(event -> relatedFilterTable.runFilters());

        CheckBox runOnDemand = new CheckBox("Filter lazily");
        runOnDemand.setValue(relatedFilterTable.isFilterOnDemand());
        runNow.setEnabled(relatedFilterTable.isFilterOnDemand());
        runOnDemand.setImmediate(true);
        runOnDemand.addValueChangeListener(event -> {
            boolean value = (Boolean) event.getProperty().getValue();
            relatedFilterTable.setFilterOnDemand(value);
            runNow.setEnabled(value);
        });
        buttonLayout.addComponent(runOnDemand);
        buttonLayout.setComponentAlignment(runOnDemand, Alignment.MIDDLE_RIGHT);
        buttonLayout.addComponent(runNow);

        Button setVal = new Button("Set the State filter to 'ImportedLead'");
        setVal.addClickListener(event -> relatedFilterTable
                .setFilterFieldValue("status", CustomerStatus.ImportedLead));
        buttonLayout.addComponent(setVal);

        Button reset = new Button("Reset");
        reset.addClickListener(event -> relatedFilterTable.resetFilters());
        buttonLayout.addComponent(reset);

        Button clear = new Button("Clear");
        clear.addClickListener(event -> relatedFilterTable.clearFilters());
        buttonLayout.addComponent(clear);

        return buttonLayout;
    }

    private Component createToggle(final FilterTable relatedFilterTable,
                                   final Object propId) {
        CheckBox toggle = new CheckBox(propId.toString());
        toggle.setValue(relatedFilterTable.isFilterFieldVisible(propId));
        toggle.setImmediate(true);
        toggle.addValueChangeListener(event -> relatedFilterTable.setFilterFieldVisible(propId,
                !relatedFilterTable.isFilterFieldVisible(propId)));
        return toggle;
    }

    private Component createToggle(final FilterTreeTable relatedFilterTable,
                                   final Object propId) {
        CheckBox toggle = new CheckBox(propId.toString());
        toggle.setValue(relatedFilterTable.isFilterFieldVisible(propId));
        toggle.setImmediate(true);
        toggle.addValueChangeListener(event -> relatedFilterTable.setFilterFieldVisible(propId,
                !relatedFilterTable.isFilterFieldVisible(propId)));
        return toggle;
    }
}
