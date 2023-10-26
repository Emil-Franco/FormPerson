package com.FormUser.Person.service;


import com.FormUser.Person.domain.entities.Person;
import com.FormUser.Person.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonService {

    private final PersonRepository personRepository;


    public CreatePersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person createUser(Person person){
        return personRepository.save(person);
    }
}
