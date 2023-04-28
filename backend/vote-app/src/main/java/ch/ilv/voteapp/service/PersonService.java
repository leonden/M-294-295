package ch.ilv.voteapp.service;

import ch.ilv.voteapp.base.MessageResponse;
import ch.ilv.voteapp.dataaccess.EntityNotFoundException;
import ch.ilv.voteapp.entity.person.Person;
import ch.ilv.voteapp.repository.PersonRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersons() {
        return repository.findByOrderByLastNameAscFirstNameAsc();
    }

    public Person getPerson(Long id) {
        return repository.findById(id) .orElseThrow(() -> new EntityNotFoundException(id, Person.class));
    }

    public Person insertPerson(Person person) {
        return repository.save(person);
    }

    public Person updatePerson(Person person, Long id) {
        return repository.findById(id).map(personOrig -> {
            personOrig.setFirstName(person.getFirstName());
            personOrig.setLastName(person.getLastName());
            personOrig.setAdult(person.isAdult());
            personOrig.setSex(person.getSex());
            personOrig.setAge(person.getAge());
            personOrig.setStreet(person.getStreet());
            personOrig.setCity(person.getCity());
            personOrig.setZipCode(person.getZipCode());
            return repository.save(personOrig);
        }).orElseGet(() -> repository.save(person));
    }

    public MessageResponse deletePerson(Long id) {
        repository.deleteById(id);
        return new MessageResponse("Person " + id + " deleted");
    }
}
