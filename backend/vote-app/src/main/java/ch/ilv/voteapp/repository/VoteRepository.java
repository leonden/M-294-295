package ch.ilv.voteapp.repository;


import ch.ilv.voteapp.entity.vote.Vote;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface VoteRepository  extends JpaRepository<Vote, Long> {

    List<Vote> findByOrderByPersonAsc();

}
