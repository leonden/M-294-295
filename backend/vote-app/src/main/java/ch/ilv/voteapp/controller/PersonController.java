package ch.ilv.voteapp.controller;

import ch.ilv.voteapp.entity.Person;
import ch.ilv.voteapp.repository.PersonRepository;
import ch.ilv.voteapp.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name="bearerAuth")
@RestController
public class PersonController {

    public final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @RolesAllowed("admin")
    @PostMapping("api/v1/person")
    public String savePerson(@RequestBody Person person) {
        personRepository.save(person);
        return "\"" + person.getFirstName() + " " + person.getLastName() + "\" saved";
    }

    @RolesAllowed("admin")
    @GetMapping ("api/v1/person")
    public String getPerson(@RequestBody Person person) {
        personRepository.save(person);
        return "Got \"" + person.getFirstName() + " " + person.getLastName() + "\"";
    }

    @RolesAllowed("admin")
    @DeleteMapping ("api/v1/person")
    public String deletePerson(@RequestBody Person person) {
        personRepository.save(person);
        return "\"" + person.getFirstName() + " " + person.getLastName() + "\" deleted";
    }


}
