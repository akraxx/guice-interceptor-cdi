package fr.mmarie.samples;

import com.google.inject.AbstractModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.inject.matcher.Matchers.annotatedWith;
import static com.google.inject.matcher.Matchers.any;

/**
 * Guice interceptor module.
 */
public class InterceptorModule extends AbstractModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterceptorModule.class);

    @Override
    protected void configure() {
        LOGGER.info("Initialize '{}'", getClass().getSimpleName());

        bindInterceptor(any(), annotatedWith(ActionLog.class), getActionLogInterceptor());
    }

    private ActionLogInterceptor getActionLogInterceptor() {
        ActionLogInterceptor actionLogInterceptor = new ActionLogInterceptor();
        requestInjection(actionLogInterceptor);

        return actionLogInterceptor;
    }
}
