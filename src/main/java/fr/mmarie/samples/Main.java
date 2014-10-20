package fr.mmarie.samples;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fr.mmarie.samples.actor.ActorModule;
import fr.mmarie.samples.actor.ActorService;

/**
 * Created by A567336 on 23/09/2014.
 */
public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new InterceptorModule(), new ActorModule());
        ActorService instance = injector.getInstance(ActorService.class);
        instance.update("test1");
        instance.update("test2");

        ActorService instance2 = injector.getInstance(ActorService.class);
    }
}
