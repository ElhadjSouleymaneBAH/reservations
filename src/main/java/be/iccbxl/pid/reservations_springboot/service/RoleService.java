package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.Role;
import be.iccbxl.pid.reservations_springboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Récupère tous les rôles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Récupère un rôle par son ID
    public Role getRole(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null); // Retourne null si aucun rôle n'est trouvé
    }

    // Ajoute un nouveau rôle
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    // Met à jour un rôle existant
    public Role updateRole(Long id, Role updatedRole) {
        Optional<Role> optionalRole = roleRepository.findById(id);

        if (optionalRole.isPresent()) {
            Role existingRole = optionalRole.get();
            existingRole.setRole(updatedRole.getRole()); // Met à jour le champ `role`
            return roleRepository.save(existingRole);
        }

        return null; // Retourne null si le rôle n'existe pas
    }

    // Supprime un rôle
    public boolean deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true; // Retourne true si la suppression est réussie
        }
        return false; // Retourne false si le rôle n'existe pas
    }
}

