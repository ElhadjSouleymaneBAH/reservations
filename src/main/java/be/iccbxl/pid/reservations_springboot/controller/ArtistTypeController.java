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
import java.util.Optional;

@Controller
@RequestMapping("/artist-types")
public class ArtistTypeController {

    @Autowired
    private ArtistTypeService service;

    //  Afficher la liste des relations ArtistType
    @GetMapping
    public String index(Model model) {
        model.addAttribute("artistTypes", service.getAllArtistTypes());
        return "artistType/index";
    }

    //  Afficher un ArtistType par ID avec gestion des erreurs
    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model, RedirectAttributes redirAttrs) {
        Optional<ArtistType> artistType = service.getArtistTypeById(id);

        if (artistType.isPresent()) {
            model.addAttribute("artistType", artistType.get());
            return "artistType/show";
        } else {
            redirAttrs.addFlashAttribute("errorMessage", "Type d'artiste introuvable !");
            return "redirect:/artist-types";
        }
    }

    //  Formulaire de création
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("artistType", new ArtistType());
        return "artistType/create";
    }

    //  Sauvegarder une nouvelle relation ArtistType
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute ArtistType artistType, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "artistType/create";
        }
        service.addArtistType(artistType);
        redirAttrs.addFlashAttribute("successMessage", "Type d'artiste créé avec succès.");
        return "redirect:/artist-types";
    }

    //  Formulaire de modification avec gestion des erreurs
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model, RedirectAttributes redirAttrs) {
        Optional<ArtistType> artistType = service.getArtistTypeById(id);

        if (artistType.isPresent()) {
            model.addAttribute("artistType", artistType.get());
            return "artistType/edit";
        } else {
            redirAttrs.addFlashAttribute("errorMessage", "Type d'artiste introuvable !");
            return "redirect:/artist-types";
        }
    }

    // Mettre à jour une relation ArtistType avec vérification
    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute ArtistType artistType, BindingResult bindingResult, @PathVariable Long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "artistType/edit";
        }

        Optional<ArtistType> existingArtistType = service.getArtistTypeById(id);
        if (existingArtistType.isPresent()) {
            service.addArtistType(artistType);
            redirAttrs.addFlashAttribute("successMessage", "Type d'artiste mis à jour avec succès.");
        } else {
            redirAttrs.addFlashAttribute("errorMessage", "Type d'artiste introuvable !");
        }
        return "redirect:/artist-types";
    }

    // Supprimer une relation ArtistType avec vérification
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirAttrs) {
        Optional<ArtistType> artistType = service.getArtistTypeById(id);

        if (artistType.isPresent()) {
            service.removeArtistType(id);
            redirAttrs.addFlashAttribute("successMessage", "Type d'artiste supprimé avec succès.");
        } else {
            redirAttrs.addFlashAttribute("errorMessage", "Type d'artiste introuvable !");
        }
        return "redirect:/artist-types";
    }
}
