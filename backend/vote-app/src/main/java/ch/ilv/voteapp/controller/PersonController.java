package ch.ilv.voteapp.controller;

import ch.ilv.voteapp.model.Person;
import ch.ilv.voteapp.repository.PersonRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name="bearerAuth")
@RestController
public class PersonController {

    public final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RolesAllowed("admin")
    @PostMapping("/save-person")
    public String savePerson(@RequestBody Person person) {
        personRepository.save(person);
        return person.getFirstName() + " " + person.getLastName() + " saved";
    }

}
