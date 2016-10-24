package org.apache.vaadin.ui;

import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.data.util.filter.UnsupportedFilterException;
import org.apache.vaadin.ui.model.Customer;

import java.util.List;

/**
 * Created by tringuyen on 10/20/16.
 */
public class CustomerContainer extends BeanContainer<Integer, Customer> {
    public CustomerContainer(Class type) {
        super(type);
        CustomerService.getInstance().findAll().stream().forEach(customer -> {
            this.addItem(getId(), customer);
        });
        ID = 0;
    }

    private static int ID = 0;
    private int getId() {
        return ++ID;
    }

//    @Override
//    public List<?> getItemIds(final int startIndex, final int numberOfItems) {
//        int end = startIndex + numberOfItems;
//        // TODO: here you should place fetching data from database (it should be paged SQL of course)
//        System.out.println("start: " + startIndex + ", end: " + end);
//        List<Customer> res = CustomerService.getInstance().findAll().subList(startIndex, end);
//        return res;
//    }


}
