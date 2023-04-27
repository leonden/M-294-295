package ch.ilv.voteapp.repository;

import ch.ilv.voteapp.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
}
