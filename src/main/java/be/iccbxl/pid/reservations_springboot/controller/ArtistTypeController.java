package be.iccbxl.pid.reservations_springboot.controller;



import be.iccbxl.pid.reservations_springboot.model.ArtistType;
import be.iccbxl.pid.reservations_springboot.service.ArtistTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/artist-types")
public class ArtistTypeController {
    @Autowired
    ArtistTypeService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("artistTypes", service.getAllArtistTypes());
        return "artistType/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("artistType", service.getArtistType(id));
        return "artistType/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("artistType", new ArtistType());
        return "artistType/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute ArtistType artistType, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "artistType/create";
        }
        service.addArtistType(artistType);
        redirAttrs.addFlashAttribute("successMessage", "Type d'artiste créé avec succès.");
        return "redirect:/artist-types";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("artistType", service.getArtistType(id));
        return "artistType/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute ArtistType artistType, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "artistType/edit";
        }
        service.updateArtistType(id, artistType);
        redirAttrs.addFlashAttribute("successMessage", "Type d'artiste mis à jour avec succès.");
        return "redirect:/artist-types";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteArtistType(id);
        redirAttrs.addFlashAttribute("successMessage", "Type d'artiste supprimé avec succès.");
        return "redirect:/artist-types";
    }
}
