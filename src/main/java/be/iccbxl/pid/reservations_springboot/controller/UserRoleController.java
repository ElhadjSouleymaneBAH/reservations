package be.iccbxl.pid.reservations_springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import be.iccbxl.pid.reservations_springboot.model.UserRole;
import be.iccbxl.pid.reservations_springboot.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/userroles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAllRoles() {
        return userRoleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public UserRole getRoleById(@PathVariable long id) {
        return userRoleService.getRoleById(id);
    }

    @PostMapping
    public UserRole createRole(@RequestBody UserRole userRole) {
        return userRoleService.createRole(userRole);
    }

    @PutMapping("/{id}")
    public UserRole updateRole(@PathVariable long id, @RequestBody UserRole userRole) {
        return userRoleService.updateRole(id, userRole);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable long id) {
        userRoleService.deleteRole(id);
    }
}