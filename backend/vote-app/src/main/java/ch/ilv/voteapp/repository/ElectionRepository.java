package ch.ilv.voteapp.repository;

import ch.ilv.voteapp.model.Admin;
import ch.ilv.voteapp.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
}
