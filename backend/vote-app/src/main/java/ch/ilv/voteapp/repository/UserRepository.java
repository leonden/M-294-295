package ch.ilv.voteapp.repository;

import ch.ilv.voteapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
