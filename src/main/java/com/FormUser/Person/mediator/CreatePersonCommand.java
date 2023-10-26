package com.FormUser.Person.mediator;

import an.awesome.pipelinr.Command;
import com.FormUser.Person.domain.entities.Person;

public class CreatePersonCommand implements Command {
    private final Person person;

    public CreatePersonCommand(Person person) {
        this.person = person;
    }

    public Person getPerson(){
        return person;
    }
}
