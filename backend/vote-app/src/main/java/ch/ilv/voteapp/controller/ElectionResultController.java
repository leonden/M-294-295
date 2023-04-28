package ch.ilv.voteapp.controller;

import ch.ilv.voteapp.base.MessageResponse;
import ch.ilv.voteapp.entity.electionresult.ElectionResult;
import ch.ilv.voteapp.security.Roles;
import ch.ilv.voteapp.service.ElectionResultService;
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
public class ElectionResultController {

    public final ElectionResultService electionResultService;

    public ElectionResultController(ElectionResultService electionResultService) {
        this.electionResultService = electionResultService;
    }

    @GetMapping("api/v1/election-result")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<ElectionResult>> all() {
        List<ElectionResult> result = electionResultService.getElectionResults();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/v1/election-result/{id}")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<ElectionResult> one(@PathVariable Long id) {
        ElectionResult electionResult = electionResultService.getElectionResult(id);
        return new ResponseEntity<>(electionResult, HttpStatus.OK);
    }

    @PostMapping("api/v1/election-result")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<ElectionResult> newElectionResult(@Valid @RequestBody ElectionResult electionResult) {
        ElectionResult savedElectionResult = electionResultService.insertElectionResult(electionResult);
        return new ResponseEntity<>(savedElectionResult, HttpStatus.OK);
    }

    @PutMapping("api/v1/election-result/{id}")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<ElectionResult> updateElectionResult(@Valid @RequestBody ElectionResult electionResult, @PathVariable Long id) {
        ElectionResult savedElectionResult = electionResultService.updateElectionResult(electionResult, id);
        return new ResponseEntity<>(savedElectionResult, HttpStatus.OK);
    }

    @DeleteMapping("api/v1/election-result/{id}")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<MessageResponse> deleteElectionResult(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(electionResultService.deleteElectionResult(id));
        } catch (Throwable t) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
