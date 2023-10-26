package com.FormUser.Person.mediator;

import com.FormUser.Person.domain.entities.Person;
import org.hibernate.query.Query;

public abstract class GetPersonByIdQuery implements Query<Person> {

    private final Long id;

    public GetPersonByIdQuery(Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}
