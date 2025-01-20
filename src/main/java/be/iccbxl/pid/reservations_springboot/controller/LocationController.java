package be.iccbxl.pid.reservations_springboot.controller;



import be.iccbxl.pid.reservations_springboot.model.Location;
import be.iccbxl.pid.reservations_springboot.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    LocationService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("locations", service.getAllLocations());
        return "location/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("location", service.getLocation(id));
        return "location/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("location", new Location());
        return "location/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Location location, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "location/create";
        }
        service.addLocation(location);
        redirAttrs.addFlashAttribute("successMessage", "Emplacement créé avec succès.");
        return "redirect:/locations";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("location", service.getLocation(id));
        return "location/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Location location, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "location/edit";
        }
        service.updateLocation(id, location);
        redirAttrs.addFlashAttribute("successMessage", "Emplacement mis à jour avec succès.");
        return "redirect:/locations";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteLocation(id);
        redirAttrs.addFlashAttribute("successMessage", "Emplacement supprimé avec succès.");
        return "redirect:/locations";
    }
}
