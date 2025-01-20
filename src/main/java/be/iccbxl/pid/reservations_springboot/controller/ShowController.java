package be.iccbxl.pid.reservations_springboot.controller;


import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    ShowService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("shows", service.getAllShows());
        return "show/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("show", service.getShow(id));
        return "show/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("show", new Show());
        return "show/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Show show, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "show/create";
        }
        service.addShow(show);
        redirAttrs.addFlashAttribute("successMessage", "Spectacle créé avec succès.");
        return "redirect:/shows";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("show", service.getShow(id));
        return "show/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Show show, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "show/edit";
        }
        service.updateShow(id, show);
        redirAttrs.addFlashAttribute("successMessage", "Spectacle mis à jour avec succès.");
        return "redirect:/shows";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteShow(id);
        redirAttrs.addFlashAttribute("successMessage", "Spectacle supprimé avec succès.");
        return "redirect:/shows";
    }
}
