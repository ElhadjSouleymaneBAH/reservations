package be.iccbxl.pid.reservations_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import be.iccbxl.pid.reservations_springboot.model.Artist;
import be.iccbxl.pid.reservations_springboot.service.ArtistService;

@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    // Affichage du formulaire de création
    @GetMapping("/artists/create")
    public String create(Model model) {
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        return "artist/create";  // Nom du template Thymeleaf
    }

    // Gestion de l'envoi du formulaire
    @PostMapping("/artists/create")
    public String store(@Valid @ModelAttribute Artist artist, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "artist/create";  // Retourne le formulaire avec les erreurs
        }
        service.addArtist(artist);  // Ajoute l'artiste si aucune erreur
        return "redirect:/artists/" + artist.getId();  // Redirection après ajout
    }
}
