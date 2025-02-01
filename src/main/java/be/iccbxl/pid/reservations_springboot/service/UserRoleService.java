package be.iccbxl.pid.reservations_springboot.service;

import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservations_springboot.model.UserRole;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRoleService {

    // Récupérer tous les rôles disponibles
    public List<UserRole> getAllRoles() {
        return Arrays.asList(UserRole.values()); // Retourne tous les rôles définis dans l'énumération
    }

    // Vérifier si un rôle existe
    public boolean isValidRole(String role) {
        return Arrays.stream(UserRole.values())
                .anyMatch(r -> r.getValue().equalsIgnoreCase(role));
    }

    // Récupérer un rôle spécifique (par sa valeur)
    public UserRole getRole(String role) {
        return Arrays.stream(UserRole.values())
                .filter(r -> r.getValue().equalsIgnoreCase(role))
                .findFirst()
                .orElse(null); // Retourne null si le rôle n'existe pas
    }

    public void deleteRole(long id) {
    }


    public be.iccbxl.pid.reservations_springboot.model.UserRole getRoleById(long id) {
        return null;
    }

    public be.iccbxl.pid.reservations_springboot.model.UserRole createRole(be.iccbxl.pid.reservations_springboot.model.UserRole userRole) {
        return userRole;
    }

    public be.iccbxl.pid.reservations_springboot.model.UserRole updateRole(long id, be.iccbxl.pid.reservations_springboot.model.UserRole userRole) {
        return userRole;
    }
}
