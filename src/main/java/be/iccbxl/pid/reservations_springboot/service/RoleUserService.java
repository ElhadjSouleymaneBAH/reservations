package be.iccbxl.pid.reservations_springboot.service;


import be.iccbxl.pid.reservations_springboot.model.RoleUser;
import be.iccbxl.pid.reservations_springboot.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleUserService {
    @Autowired
    private RoleUserRepository repository;

    public List<RoleUser> getAllRoleUsers() {
        return repository.findAll();
    }

    public RoleUser getRoleUser(long id) {
        return repository.findById(id);
    }

    public void addRoleUser(RoleUser roleUser) {
        repository.save(roleUser);
    }

    public void updateRoleUser(long id, RoleUser roleUser) {
        repository.save(roleUser);
    }

    public void deleteRoleUser(long id) {
        repository.deleteById(id);
    }
}
