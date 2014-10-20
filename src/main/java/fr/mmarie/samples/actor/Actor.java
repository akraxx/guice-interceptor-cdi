package fr.mmarie.samples.actor;

import fr.mmarie.samples.ActionLogModify;
import lombok.Getter;

/**
 * Created by A567336 on 23/09/2014.
 */
@Getter
public class Actor {
    @ActionLogModify(type = "name")
    private String name;

    private String test;

    public Actor(String name) {
        this.name = name;
    }
}
