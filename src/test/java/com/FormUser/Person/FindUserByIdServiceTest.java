package com.FormUser.Person;

import com.FormUser.Person.domain.entities.Person;
import com.FormUser.Person.repository.PersonRepository;
import com.FormUser.Person.service.FindUserByIdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindUserByIdServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private FindUserByIdService findUserByIdService;


    @Test
    public void shouldFindUserById() {
        // Arrange
        Long id = 1L;
        Person person = new Person();
        person.setNombre("Juan");
        person.setApellido("Pérez");
        person.setEdad(25);
        person.setDescripcion("Un buen hombre");

        when(personRepository.findById(id)).thenReturn(Optional.of(person));

        Person foundPerson = findUserByIdService.finbyId(id);

        assertEquals(person, foundPerson);
    }

    public void shouldReturnNullWhenUserNotFound(){
        Long id = 1L;

        when(personRepository.findById(id)).thenReturn(Optional.empty());

        Person foundPerson = findUserByIdService.finbyId(id);

        assertNull(foundPerson);
    }
}
