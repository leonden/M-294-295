package ch.ilv.voteapp.controller;

import ch.ilv.voteapp.model.User;
import ch.ilv.voteapp.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    public final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/save-user")
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return user.getFirstName() + " " + user.getLastName() + " updated!";
    }

}
