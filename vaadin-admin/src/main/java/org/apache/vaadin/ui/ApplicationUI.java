package org.apache.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import org.apache.vaadin.ui.layout.MasterLayoutUI;
import org.apache.vaadin.ui.view.DashboardView;
import org.apache.vaadin.ui.view.SimpleGridView;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p/>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("admintheme")
public class ApplicationUI extends AbstractUI {

    @Override
    protected View getDefaultView(NavigatorUIContainer container, VaadinRequest request) {
        return new DashboardView(container, request);
    }

    @Override
    protected void addViews(NavigatorUIContainer container, VaadinRequest request) {
    }

    @WebServlet(urlPatterns = "/*", name = "AdminUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ApplicationUI.class, productionMode = false)
    public static class AdminUIServlet extends VaadinServlet {
    }
}
