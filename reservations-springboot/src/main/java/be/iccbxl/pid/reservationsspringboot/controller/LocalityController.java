package be.iccbxl.pid.reservationsspringboot.controller;


import be.iccbxl.pid.reservationsspringboot.model.Locality;
import be.iccbxl.pid.reservationsspringboot.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/localities")
public class LocalityController {
    @Autowired
    private LocalityService service;

    @GetMapping
    public String index(Model model) {
        List<Locality> localities = service.getAll();
        model.addAttribute("localities", localities);
        model.addAttribute("title", "Liste des localités");
        return "locality/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Locality locality = service.get(id);
        if (locality == null) {
            model.addAttribute("errorMessage", "Localité introuvable !");
            return "error";
        }
        model.addAttribute("locality", locality);
        model.addAttribute("title", "Fiche d'une localité");
        return "locality/show";
    }
}

