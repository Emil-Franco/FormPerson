package com.FormUser.Person.service;

import com.FormUser.Person.domain.entities.Person;
import com.FormUser.Person.repository.PersonRepository;
import org.springframework.stereotype.Service;


@Service
public class FindUserByIdService {

    private final PersonRepository personRepository;

    public FindUserByIdService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person finbyId(Long id){
        return personRepository.findById(id).orElse(null);
    }
}
