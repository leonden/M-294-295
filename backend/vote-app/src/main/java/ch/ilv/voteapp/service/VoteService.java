package ch.ilv.voteapp.service;

import ch.ilv.voteapp.base.MessageResponse;
import ch.ilv.voteapp.dataaccess.EntityNotFoundException;
import ch.ilv.voteapp.entity.vote.Vote;
import ch.ilv.voteapp.repository.VoteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public List<Vote> getVotes() {
        return repository.findByOrderByPersonAsc();
    }

    public Vote getVote(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Vote.class));
    }

    public Vote insertVote(Vote vote) {
        return repository.save(vote);
    }

    public Vote updateVote(Vote vote, Long id) {
        return repository.findById(id).map(voteOrig -> {
            voteOrig.setElection(vote.getElection());
            voteOrig.setPerson(vote.getPerson());
            voteOrig.setVotedFor(vote.getVotedFor());
            return repository.save(voteOrig);
        }).orElseGet(() -> repository.save(vote));
    }

    public MessageResponse deleteVote(Long id) {
        repository.deleteById(id);
        return new MessageResponse("Vote " + id + " deleted");
    }
}
