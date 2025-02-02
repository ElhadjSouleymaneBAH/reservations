package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.User;
import be.iccbxl.pid.reservationsspringboot.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
    }

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Sécuriser le mot de passe
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUser(id);
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }
        return userRepository.save(user);
    }

    public User updateUserProfile(Long id, String firstname, String lastname, String email, String password, String profilePicturePath) {
        User user = getUser(id);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        if (password != null && !password.isEmpty()) {
            user.setPassword(passwordEncoder.encode(password));
        }
        if (profilePicturePath != null && !profilePicturePath.isEmpty()) {
            user.setProfilePicturePath(profilePicturePath);
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
