package ch.ilv.voteapp.repository;

import ch.ilv.voteapp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
