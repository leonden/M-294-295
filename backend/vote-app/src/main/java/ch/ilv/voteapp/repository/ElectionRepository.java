package ch.ilv.voteapp.repository;

import ch.ilv.voteapp.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionRepository extends JpaRepository<Election, Long> {

    List<Election> findByOrderByTitleAsc();

}
