package com.FormUser.Person.mediator;

import an.awesome.pipelinr.Command;
import org.hibernate.query.Query;

public interface Mediator {
    void sendCommand(Command command);
    <R> R query(Query<R> query);
}
