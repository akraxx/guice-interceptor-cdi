package fr.mmarie.samples.actor;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by A567336 on 23/09/2014.
 */
public class ActorModule extends AbstractModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActorModule.class);

    @Override
    protected void configure() {
        LOGGER.info("Initialize '{}'", getClass().getSimpleName());
    }

    @Provides
    @ActorVisitor
    @Singleton
    public Actor providesVisitor() {
        LOGGER.info("Visitor Provided");
        return new Actor("visitor provided");
    }

    @Provides
    @ActorAdmin
    public Actor providesAdmin() {
        LOGGER.info("Admin Provided");
        return new Actor("admin provided");
    }
}
