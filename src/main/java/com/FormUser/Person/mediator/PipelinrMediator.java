package com.FormUser.Person.mediator;

import an.awesome.pipelinr.Command;
import com.FormUser.Person.service.CreatePersonService;
import com.FormUser.Person.service.FindUserByIdService;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

@Component
public class PipelinrMediator implements Mediator{

    private final CreatePersonService createPersonService;
    private final FindUserByIdService findUserByIdService;

    public PipelinrMediator(CreatePersonService createPersonService, FindUserByIdService findUserByIdService) {
        this.createPersonService = createPersonService;
        this.findUserByIdService = findUserByIdService;
    }


    @Override
    public void sendCommand(Command command) {
        if (command instanceof CreatePersonCommand){
            createPersonService.createUser(((CreatePersonCommand)command).getPerson());
        }else {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public <R> R query(Query<R> query) {
        if (query instanceof GetPersonByIdQuery) {
            return (R) findUserByIdService.finbyId(((GetPersonByIdQuery) query).getId());
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
