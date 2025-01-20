package be.iccbxl.pid.reservations_springboot.controller;


import be.iccbxl.pid.reservations_springboot.model.Role;
import be.iccbxl.pid.reservations_springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roles", service.getAllRoles());
        return "role/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("role", service.getRole(id));
        return "role/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("role", new Role());
        return "role/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Role role, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "role/create";
        }
        service.addRole(role);
        redirAttrs.addFlashAttribute("successMessage", "Rôle ajouté avec succès.");
        return "redirect:/roles";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("role", service.getRole(id));
        return "role/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Role role, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "role/edit";
        }
        service.updateRole(id, role);
        redirAttrs.addFlashAttribute("successMessage", "Rôle mis à jour avec succès.");
        return "redirect:/roles";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteRole(id);
        redirAttrs.addFlashAttribute("successMessage", "Rôle supprimé avec succès.");
        return "redirect:/roles";
    }
}
