package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.User;
import be.iccbxl.pid.reservations_springboot.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserApiController {

    private final UserRepository userRepository;

    public UserApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    // Récupérer un utilisateur par login
    @GetMapping("/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userRepository.findByLogin(login);
    }
}