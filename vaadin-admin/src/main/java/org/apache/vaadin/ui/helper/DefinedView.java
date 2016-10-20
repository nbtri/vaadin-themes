package org.apache.vaadin.ui.helper;

import com.vaadin.navigator.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tringuyen on 10/20/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface DefinedView {
    public String viewName() default "";

    public Class<? extends View> clazz();
}
