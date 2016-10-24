package org.apache.vaadin.ui;

import com.sun.media.jfxmedia.logging.Logger;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import org.apache.vaadin.ui.helper.DefinedView;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * Created by tringuyen on 10/20/16.
 */
public abstract class AbstractUI extends UI implements NavigatorUIContainer {

    protected Navigator navigator;

    protected abstract View getDefaultView(NavigatorUIContainer container, VaadinRequest request);

    protected abstract void addViews(NavigatorUIContainer container, VaadinRequest request);

    protected void addView(String viewName, View view) {
        navigator.addView(viewName, view);
    }

    @Override
    protected void init(VaadinRequest request) {
        navigator = new Navigator(this, this);

        navigator.addView("", getDefaultView(this, request));

        Reflections reflections = new Reflections("org.apache.vaadin.ui.view");

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(DefinedView.class);

        for(Class<?> annotatedClass : annotated) {
            DefinedView definedView = annotatedClass.getAnnotation(DefinedView.class);
            Class<? extends View> clazz = definedView.clazz();
            try {
                View view = clazz.getDeclaredConstructor(NavigatorUIContainer.class, VaadinRequest.class).newInstance(this, request);
                navigator.addView(definedView.viewName(), view);
            } catch (InstantiationException e) {
                Logger.logMsg(Logger.ERROR, e.getMessage());
            } catch (IllegalAccessException e) {
                Logger.logMsg(Logger.ERROR, e.getMessage());
            } catch (InvocationTargetException e) {
                Logger.logMsg(Logger.ERROR, e.getMessage());
            } catch (NoSuchMethodException e) {
                Logger.logMsg(Logger.ERROR, e.getMessage());
            }
        }

        addViews(this, request);
    }
}
