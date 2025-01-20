package be.iccbxl.pid.reservations_springboot.controller;

import be.iccbxl.pid.reservations_springboot.model.User;
import be.iccbxl.pid.reservations_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "user/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "user/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        service.addUser(user);
        redirAttrs.addFlashAttribute("successMessage", "Utilisateur ajouté avec succès.");
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "user/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute User user, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        service.updateUser(id, user);
        redirAttrs.addFlashAttribute("successMessage", "Utilisateur mis à jour avec succès.");
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteUser(id);
        redirAttrs.addFlashAttribute("successMessage", "Utilisateur supprimé avec succès.");
        return "redirect:/users";
    }
}
