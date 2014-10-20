package fr.mmarie.samples;

import com.google.inject.name.Named;
import fr.mmarie.samples.actor.Actor;
import fr.mmarie.samples.actor.ActorAdmin;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by A567336 on 23/09/2014.
 */
public class ActionLogInterceptor implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActionLogInterceptor.class);

    @Inject
    @ActorAdmin
    private Actor actor;

    public ActionLogInterceptor() {
        LOGGER.debug("Initialize ActionLogInterceptor");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Annotation[] annotations = methodInvocation.getMethod().getDeclaredAnnotations();
        LOGGER.debug("Annotations : " + annotations.length);

        for(Annotation annotation : annotations) {
            if(annotation.annotationType().equals(ActionLog.class)) {
                ActionLog actionLog = (ActionLog) annotation;
                LOGGER.debug("type of annotation [{}], [{}]", actionLog.type(), actionLog.objectType());
            }
        }

        for(Field field : Actor.class.getDeclaredFields()) {
            if(field.isAnnotationPresent(ActionLogModify.class)){
                LOGGER.debug("Logged field [{}]", field);
            }
        }
        LOGGER.debug("Method arguments : [{}]", methodInvocation.getArguments().length);


        Object proceed = methodInvocation.proceed();
        LOGGER.debug("After method");
        return proceed;
    }

}
