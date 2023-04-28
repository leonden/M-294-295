package ch.ilv.voteapp.person;


import ch.ilv.voteapp.entity.person.Person;
import ch.ilv.voteapp.repository.PersonRepository;
import ch.ilv.voteapp.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersonServiceTests {

    private PersonService personService;
    private final PersonRepository personRepositoryMock = mock(PersonRepository.class);

    private final Person personMock = mock(Person.class);

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepositoryMock);
    }

    @Test
    void createPerson() {
        when(personRepositoryMock.save(personMock)).thenReturn(personMock);
        personService.insertPerson(personMock);
        verify(personRepositoryMock, times(1)).save(any());
    }

    @Test
    void findPerson() {
        when(personRepositoryMock.findById(any())).thenReturn(Optional.ofNullable(personMock));
        Person v = personService.getPerson(any());
        verify(personRepositoryMock, times(1)).findById(any());
    }

    @Test
    void deletePerson() {
        personService.deletePerson(any());
        verify(personRepositoryMock, times(1)).deleteById(any());
    }
}