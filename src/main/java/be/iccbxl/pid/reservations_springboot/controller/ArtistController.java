package be.iccbxl.pid.reservations_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import be.iccbxl.pid.reservations_springboot.model.Artist;
import be.iccbxl.pid.reservations_springboot.service.ArtistService;

@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    //…

    @DeleteMapping("/artists/{id}")
    public String delete(@PathVariable long id, Model model) {
        Artist existing = service.getArtist(id);

        if(existing!=null) {
            service.deleteArtist(id);
        }

        return "redirect:/artists";
    }

}

