package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.Role;
import be.iccbxl.pid.reservations_springboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    public Role getRole(long id) {
        return repository.findById(id);
    }

    public Role getRoleByName(String name) {
        return repository.findByName(name);
    }

    public void addRole(Role role) {
        repository.save(role);
    }

    public void updateRole(long id, Role role) {
        repository.save(role);
    }

    public void deleteRole(long id) {
        repository.deleteById(id);
    }
}
