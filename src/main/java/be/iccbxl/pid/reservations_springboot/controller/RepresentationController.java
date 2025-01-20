package be.iccbxl.pid.reservations_springboot.controller;

import be.iccbxl.pid.reservations_springboot.model.Representation;
import be.iccbxl.pid.reservations_springboot.service.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/representations")
public class RepresentationController {
    @Autowired
    RepresentationService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("representations", service.getAllRepresentations());
        return "representation/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("representation", service.getRepresentation(id));
        return "representation/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("representation", new Representation());
        return "representation/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Representation representation, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "representation/create";
        }
        service.addRepresentation(representation);
        redirAttrs.addFlashAttribute("successMessage", "Représentation ajoutée avec succès.");
        return "redirect:/representations";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("representation", service.getRepresentation(id));
        return "representation/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Representation representation, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "representation/edit";
        }
        service.updateRepresentation(id, representation);
        redirAttrs.addFlashAttribute("successMessage", "Représentation mise à jour avec succès.");
        return "redirect:/representations";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteRepresentation(id);
        redirAttrs.addFlashAttribute("successMessage", "Représentation supprimée avec succès.");
        return "redirect:/representations";
    }
}

