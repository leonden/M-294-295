package ch.ilv.voteapp.repository;

import ch.ilv.voteapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
