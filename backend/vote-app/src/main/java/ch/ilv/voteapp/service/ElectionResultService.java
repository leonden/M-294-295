package ch.ilv.voteapp.service;

import ch.ilv.voteapp.base.MessageResponse;
import ch.ilv.voteapp.entity.electionresult.ElectionResult;
import ch.ilv.voteapp.repository.ElectionResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionResultService {


    private final ElectionResultRepository repository;

    public ElectionResultService(ElectionResultRepository repository) {
        this.repository = repository;
    }

    public List<ElectionResult> getElectionResults() {
        return repository.findByOrderByTitleAsc();
    }

    public ElectionResult getElectionResult(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public ElectionResult insertElectionResult(ElectionResult electionResult) {
        return repository.save(electionResult);
    }

    public ElectionResult updateElectionResult(ElectionResult electionResult, Long id) {
        return repository.findById(id).map(electionResultOrig -> {
            electionResultOrig.setTitle(electionResult.getTitle());
            electionResultOrig.setResult(electionResult.getResult());
            electionResultOrig.setVotes(electionResult.getVotes());
            electionResultOrig.setAmountMale(electionResult.getAmountMale());
            electionResultOrig.setAmountFemale(electionResult.getAmountFemale());
            return repository.save(electionResultOrig);
        }).orElseGet(() -> repository.save(electionResult));
    }

    public MessageResponse deleteElectionResult(Long id) {
        repository.deleteById(id);
        return new MessageResponse("ElectionResult " + id + " deleted");
    }
}
