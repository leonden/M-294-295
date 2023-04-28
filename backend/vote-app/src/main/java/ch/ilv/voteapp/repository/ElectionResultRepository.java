package ch.ilv.voteapp.repository;

import ch.ilv.voteapp.entity.electionresult.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionResultRepository extends JpaRepository<ElectionResult, Long> {

    List<ElectionResult> findByOrderByTitleAsc();

}