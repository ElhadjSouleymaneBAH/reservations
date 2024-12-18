package be.iccbxl.pid.reservationsspringboot.service;

import be.iccbxl.pid.reservationsspringboot.model.Role;
import be.iccbxl.pid.reservationsspringboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();
        repository.findAll().forEach(roles::add);
        return roles;
    }

    public Role get(Long id) {
        Optional<Role> role = repository.findById(id);
        return role.orElse(null);
    }

    public void save(Role role) {
        repository.save(role);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

