package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.User;
import be.iccbxl.pid.reservations_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(long id) {
        return repository.findById(id);
    }

    public void addUser(User user) {
        repository.save(user);
    }

    public void updateUser(long id, User user) {
        repository.save(user);
    }

    public void deleteUser(long id) {
        repository.deleteById(id);
    }
}
