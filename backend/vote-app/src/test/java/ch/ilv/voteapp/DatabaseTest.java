package ch.ilv.voteapp;

import ch.ilv.voteapp.entity.person.Person;
import ch.ilv.voteapp.entity.person.Sex;
import ch.ilv.voteapp.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DatabaseTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void insertPerson() {
        Person personMale = new Person("John", "Doe", true, Sex.MALE, 24, "Lombard Street 150", "San Francisco", "94123");
        Assertions.assertNotNull(personMale.getFirstName());
        Person personFemale = new Person("Jane", "Doe", true, Sex.FEMALE, 23, "Lombard Street 150", "San Francisco", "94123");
        Assertions.assertNotNull(personFemale.getFirstName());
    }

}
