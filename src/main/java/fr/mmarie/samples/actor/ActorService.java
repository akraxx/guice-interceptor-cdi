package fr.mmarie.samples.actor;

import com.google.inject.Inject;
import fr.mmarie.samples.ActionLog;
import fr.mmarie.samples.ActionLogInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by A567336 on 23/09/2014.
 */
public class ActorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActionLogInterceptor.class);

    private Actor actor;

    @Inject
    public ActorService(@ActorVisitor Actor actor) {
        this.actor = actor;
    }

    @ActionLog(type = "Update", objectType = Actor.class)
    public void update(String test) {
        LOGGER.debug("Update actor {}", test);
    }
}
