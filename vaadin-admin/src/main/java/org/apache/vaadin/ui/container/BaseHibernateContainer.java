package org.apache.vaadin.ui.container;

import com.vaadin.data.util.BeanContainer;

/**
 * Created by tringuyen on 10/21/2016.
 */
public class BaseHibernateContainer extends BeanContainer implements LazyContainer {

    public BaseHibernateContainer(Class type) {
        super(type);
    }


}
