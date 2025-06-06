package be.iccbxl.pid.reservations_springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.iccbxl.pid.reservations_springboot.model.Artist;
import be.iccbxl.pid.reservations_springboot.service.ArtistService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    // Affichage de la page de modification d'un artiste
    @GetMapping("/artists/{id}/edit")
    public String edit(Model model, @PathVariable long id, HttpServletRequest request) {
        Artist artist = service.getArtist(id);

        model.addAttribute("artist", artist);

        // Générer le lien retour pour l'annulation
        String referrer = request.getHeader("Referer");

        if (referrer != null && !referrer.equals("")) {
            model.addAttribute("back", referrer);
        } else {
            model.addAttribute("back", "/artists/" + artist.getId());
        }

        return "artist/edit";
    }

    // Modification de l'artiste sélectionné
    @PutMapping("/artists/{id}/edit")
    public String update(@Valid @ModelAttribute Artist artist, BindingResult bindingResult,
                         @PathVariable long id, Model model, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Échec de la modification de l'artiste !");
            return "artist/edit";
        }

        Artist existing = service.getArtist(id);

        if (existing == null) {
            return "artist/index";
        }

        service.updateArtist(id, artist);
        redirAttrs.addFlashAttribute("successMessage", "Artiste modifié avec succès.");

        return "redirect:/artists/" + artist.getId();
    }

    // Affichage du formulaire de création
    @GetMapping("/artists/create")
    public String create(Model model) {
        if (!model.containsAttribute("artist")) {
            model.addAttribute("artist", new Artist());
        }

        return "artist/create";
    }

    // Enregistrement d'un nouvel artiste
    @PostMapping("/artists/create")
    public String store(@Valid @ModelAttribute Artist artist, BindingResult bindingResult,
                        Model model, RedirectAttributes redirAttrs) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Échec de la création de l'artiste !");
            return "artist/create";
        }

        service.addArtist(artist);
        redirAttrs.addFlashAttribute("successMessage", "Artiste créé avec succès.");

        return "redirect:/artists/" + artist.getId();
    }

    // Suppression d'un artiste
    @DeleteMapping("/artists/{id}")
    public String delete(@PathVariable long id, Model model, RedirectAttributes redirAttrs) {
        Artist existing = service.getArtist(id);

        if (existing != null) {
            service.deleteArtist(id);
            redirAttrs.addFlashAttribute("successMessage", "Artiste supprimé avec succès.");
        } else {
            redirAttrs.addFlashAttribute("errorMessage", "Échec de la suppression de l'artiste !");
        }

        return "redirect:/artists";
    }

}

