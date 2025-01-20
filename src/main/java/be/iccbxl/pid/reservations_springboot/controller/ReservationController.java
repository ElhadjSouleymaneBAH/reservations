package be.iccbxl.pid.reservations_springboot.controller;



import be.iccbxl.pid.reservations_springboot.model.Reservation;
import be.iccbxl.pid.reservations_springboot.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    ReservationService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("reservations", service.getAllReservations());
        return "reservation/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("reservation", service.getReservation(id));
        return "reservation/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Reservation reservation, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "reservation/create";
        }
        service.addReservation(reservation);
        redirAttrs.addFlashAttribute("successMessage", "Réservation ajoutée avec succès.");
        return "redirect:/reservations";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("reservation", service.getReservation(id));
        return "reservation/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Reservation reservation, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "reservation/edit";
        }
        service.updateReservation(id, reservation);
        redirAttrs.addFlashAttribute("successMessage", "Réservation mise à jour avec succès.");
        return "redirect:/reservations";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteReservation(id);
        redirAttrs.addFlashAttribute("successMessage", "Réservation supprimée avec succès.");
        return "redirect:/reservations";
    }
}
