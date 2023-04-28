package ch.ilv.voteapp.controller;

import ch.ilv.voteapp.base.MessageResponse;
import ch.ilv.voteapp.entity.vote.Vote;
import ch.ilv.voteapp.security.Roles;
import ch.ilv.voteapp.service.VoteService;
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
public class VoteController {

    public final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("api/v1/vote")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<List<Vote>> all() {
        List<Vote> result = voteService.getVotes();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/v1/vote/{id}")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<Vote> one(@PathVariable Long id) {
        Vote vote = voteService.getVote(id);
        return new ResponseEntity<>(vote, HttpStatus.OK);
    }

    @PostMapping("api/v1/vote")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<Vote> newVote(@Valid @RequestBody Vote vote) {
        Vote savedVote = voteService.insertVote(vote);
        return new ResponseEntity<>(savedVote, HttpStatus.OK);
    }

    @PutMapping("api/v1/vote/{id}")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<Vote> updateVote(@Valid @RequestBody Vote vote, @PathVariable Long id) {
        Vote savedVote = voteService.updateVote(vote, id);
        return new ResponseEntity<>(savedVote, HttpStatus.OK);
    }

    @DeleteMapping("api/v1/vote/{id}")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<MessageResponse> deleteVote(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(voteService.deleteVote(id));
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
