package com.FormUser.Person;

import com.FormUser.Person.domain.entities.Person;
import com.FormUser.Person.repository.PersonRepository;
import com.FormUser.Person.service.CreatePersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreatePersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private CreatePersonService createPersonService;

    @Test
    public void shouldCreatePerson() {
        Person person = new Person();
        person.setNombre("Juan");
        person.setApellido("Pérez");
        person.setEdad(25);
        person.setDescripcion("Un buen hombre");

        when(personRepository.save(person)).thenReturn(person);

        Person createdPerson = createPersonService.createUser(person);

        assertEquals(person,createdPerson);
    }
}
