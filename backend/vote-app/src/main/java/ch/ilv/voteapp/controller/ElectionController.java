package ch.ilv.voteapp.controller;

import ch.ilv.voteapp.entity.Election;
import ch.ilv.voteapp.repository.ElectionRepository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.*;

@RestController
public class ElectionController {

    public final ElectionRepository electionRepository;

    public ElectionController(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @RolesAllowed("admin")
    @PostMapping("api/v1/election")
    public String saveElection(@RequestBody Election election) {
        electionRepository.save(election);
        return "\"" + election.getTitle() + "\" saved";
    }

    @RolesAllowed("admin")
    @GetMapping("api/v1/election")
    public String getElection(@RequestBody Election election) {
        electionRepository.save(election);
        return "Got \"" + election.getTitle() + "\"";
    }

    @RolesAllowed("admin")
    @DeleteMapping("api/v1/election")
    public String deleteElection(@RequestBody Election election) {
        electionRepository.save(election);
        return "\"" + election.getTitle() + "\" deleted";
    }

}
