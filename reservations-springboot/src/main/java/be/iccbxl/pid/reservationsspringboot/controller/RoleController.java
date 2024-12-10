package be.iccbxl.pid.reservationsspringboot.controller;

import be.iccbxl.pid.reservationsspringboot.model.Role;
import be.iccbxl.pid.reservationsspringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping
    public String index(Model model) {
        List<Role> roles = service.getAll();
        model.addAttribute("roles", roles);
        model.addAttribute("title", "Liste des rôles");
        return "role/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Role role = service.get(id);
        if (role == null) {
            model.addAttribute("errorMessage", "Rôle introuvable !");
            return "error";
        }
        model.addAttribute("role", role);
        model.addAttribute("title", "Fiche d'un rôle");
        return "role/show";
    }
}
