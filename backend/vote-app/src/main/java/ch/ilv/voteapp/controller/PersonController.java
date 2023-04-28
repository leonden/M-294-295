package ch.ilv.voteapp.controller;

import ch.ilv.voteapp.base.MessageResponse;
import ch.ilv.voteapp.entity.person.Person;
import ch.ilv.voteapp.security.Roles;
import ch.ilv.voteapp.service.PersonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name="bearerAuth")
@RestController
@Validated
public class PersonController {

    public final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("api/v1/person")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<List<Person>> all() {
        List<Person> result = personService.getPersons();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/v1/person/{id}")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<Person> one(@PathVariable Long id) {
        Person person = personService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("api/v1/person")
    @RolesAllowed(Roles.Update)
    public ResponseEntity<Person> newPerson(@Valid @RequestBody Person person) {
        Person savedPerson = personService.insertPerson(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.OK);
    }

    @PutMapping("api/v1/person/{id}")
    @RolesAllowed(Roles.Update)
    public ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person, @PathVariable Long id) {
        Person savedPerson = personService.updatePerson(person, id);
        return new ResponseEntity<>(savedPerson, HttpStatus.OK);
    }

    @DeleteMapping("api/v1/person/{id}")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<MessageResponse> deletePerson(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(personService.deletePerson(id));
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
