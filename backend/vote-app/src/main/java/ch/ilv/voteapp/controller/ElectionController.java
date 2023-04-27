package ch.ilv.voteapp.controller;

import ch.ilv.voteapp.base.MessageResponse;
import ch.ilv.voteapp.entity.Election;
import ch.ilv.voteapp.security.Roles;
import ch.ilv.voteapp.service.ElectionService;
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
public class ElectionController {

    public final ElectionService electionService;

    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    @GetMapping("api/v1/election")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Election>> all() {
        List<Election> result = electionService.getElections();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/v1/election/{id}")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<Election> one(@PathVariable Long id) {
        Election election = electionService.getElection(id);
        return new ResponseEntity<>(election, HttpStatus.OK);
    }

    @PostMapping("api/v1/election")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<Election> newElection(@Valid @RequestBody Election election) {
        Election savedElection = electionService.insertElection(election);
        return new ResponseEntity<>(savedElection, HttpStatus.OK);
    }

    @PutMapping("api/v1/election/{id}")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<Election> updateElection(@Valid @RequestBody Election election, @PathVariable Long id) {
        Election savedElection = electionService.updateElection(election, id);
        return new ResponseEntity<>(savedElection, HttpStatus.OK);
    }

    @DeleteMapping("api/v1/election/{id}")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<MessageResponse> deleteElection(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(electionService.deleteElection(id));
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
