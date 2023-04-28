package ch.ilv.voteapp.repository;

import ch.ilv.voteapp.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByOrderByLastNameAscFirstNameAsc();
}
