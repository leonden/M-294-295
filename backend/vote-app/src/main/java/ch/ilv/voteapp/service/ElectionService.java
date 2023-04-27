package ch.ilv.voteapp.service;

import ch.ilv.voteapp.base.MessageResponse;
import ch.ilv.voteapp.dataaccess.EntityNotFoundException;
import ch.ilv.voteapp.entity.Election;
import ch.ilv.voteapp.repository.ElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {


    private final ElectionRepository repository;

    public ElectionService(ElectionRepository repository) {
        this.repository = repository;
    }

    public List<Election> getElections() {
        return repository.findByOrderByTitleAsc();
    }

    public Election getElection(Long id) {
        return repository.findById(id) .orElseThrow(() -> new EntityNotFoundException(id, Election.class));
    }
    public Election insertElection(Election election) {
        return repository.save(election);
    }

    public Election updateElection(Election election, Long id) {
        return repository.findById(id).map(electionOrig -> {
            electionOrig.setTitle(election.getTitle());
            electionOrig.setDescription(election.getDescription());
            electionOrig.setProgress(election.getProgress());
            return repository.save(electionOrig);
        }).orElseGet(() -> repository.save(election));
    }

    public MessageResponse deleteElection(Long id) {
        repository.deleteById(id);
        return new MessageResponse("Election " + id + " deleted");
    }
}
