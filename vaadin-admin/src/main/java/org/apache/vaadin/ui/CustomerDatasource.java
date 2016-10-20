package org.apache.vaadin.ui;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import org.apache.vaadin.ui.model.Customer;

import java.util.List;

/**
 * Created by tringuyen on 10/20/16.
 */
public class CustomerDatasource extends BeanContainer {
    public CustomerDatasource(Class type) {
        super(type);
    }

    @Override
    public int size() {
        return CustomerService.getInstance().count();
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem(itemId);
    }

    @Override
    public List<?> getItemIds(final int startIndex, final int numberOfItems) {
        int end = startIndex + numberOfItems;
        // TODO: here you should place fetching data from database (it should be paged SQL of course)
        System.out.println("start: " + startIndex + ", end: " + end);
        List<Customer> res = CustomerService.getInstance().findAll().subList(startIndex, end);
        return res;
    }
}
