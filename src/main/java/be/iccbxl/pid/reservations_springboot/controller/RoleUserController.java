package be.iccbxl.pid.reservations_springboot.controller;


import be.iccbxl.pid.reservations_springboot.model.RoleUser;
import be.iccbxl.pid.reservations_springboot.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/role-users")
public class RoleUserController {
    @Autowired
    RoleUserService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roleUsers", service.getAllRoleUsers());
        return "roleUser/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("roleUser", service.getRoleUser(id));
        return "roleUser/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("roleUser", new RoleUser());
        return "roleUser/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute RoleUser roleUser, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "roleUser/create";
        }
        service.addRoleUser(roleUser);
        redirAttrs.addFlashAttribute("successMessage", "Association rôle-utilisateur ajoutée avec succès.");
        return "redirect:/role-users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("roleUser", service.getRoleUser(id));
        return "roleUser/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute RoleUser roleUser, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "roleUser/edit";
        }
        service.updateRoleUser(id, roleUser);
        redirAttrs.addFlashAttribute("successMessage", "Association rôle-utilisateur mise à jour avec succès.");
        return "redirect:/role-users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteRoleUser(id);
        redirAttrs.addFlashAttribute("successMessage", "Association rôle-utilisateur supprimée avec succès.");
        return "redirect:/role-users";
    }
}
