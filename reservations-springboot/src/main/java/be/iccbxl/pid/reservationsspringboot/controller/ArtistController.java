package be.iccbxl.pid.reservationsspringboot.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import be.iccbxl.pid.reservationsspringboot.model.Artist;
import be.iccbxl.pid.reservationsspringboot.service.ArtistService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    // Méthode pour afficher le formulaire de création d'un artiste
    @GetMapping("/artists/create")
    public String create(Model model) {
        Artist artist = new Artist();  // Utilisation du constructeur vide
        model.addAttribute("artist", artist);
        model.addAttribute("title", "Création d'un artiste");
        return "artist/create";
    }

    // Méthode pour sauvegarder le nouvel artiste
    @PostMapping("/artists/create")
    public String store(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Création d'un artiste"); // Remettre le titre si erreur de validation
            return "artist/create";
        }

        service.addArtist(artist);  // Enregistrement de l'artiste
        return "redirect:/artists"; // Redirection vers la liste des artistes
    }

    // Méthode pour afficher la liste de tous les artistes
    @GetMapping("/artists")
    public String index(Model model) {
        List<Artist> artists = service.getAllArtists();
        model.addAttribute("artists", artists);
        model.addAttribute("title", "Liste des artistes");
        return "artist/index";
    }

    // Méthode pour afficher la fiche d'un artiste spécifique
    @GetMapping("/artists/{id}")
    public String show(Model model, @PathVariable("id") long id) {
        Artist artist = service.getArtist(id);
        model.addAttribute("artist", artist);
        model.addAttribute("title", "Fiche d'un artiste");
        return "artist/show";
    }

    // Méthode pour afficher le formulaire de modification de l'artiste
    @GetMapping("/artists/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        Artist artist = service.getArtist(id);
        model.addAttribute("artist", artist);
        model.addAttribute("title", "Modification d'un artiste");
        return "artist/edit";
    }

    // Méthode pour mettre à jour l'artiste
    @PostMapping("/artists/{id}/edit")
    public String update(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Modification d'un artiste");
            return "artist/edit";
        }

        service.updateArtist(artist.getId(), artist);
        return "redirect:/artists/" + artist.getId();
    }
}

