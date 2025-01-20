package be.iccbxl.pid.reservations_springboot.controller;

import be.iccbxl.pid.reservations_springboot.model.Review;
import be.iccbxl.pid.reservations_springboot.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("reviews", service.getAllReviews());
        return "review/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("review", service.getReview(id));
        return "review/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("review", new Review());
        return "review/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Review review, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "review/create";
        }
        service.addReview(review);
        redirAttrs.addFlashAttribute("successMessage", "Avis ajouté avec succès.");
        return "redirect:/reviews";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("review", service.getReview(id));
        return "review/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Review review, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "review/edit";
        }
        service.updateReview(id, review);
        redirAttrs.addFlashAttribute("successMessage", "Avis mis à jour avec succès.");
        return "redirect:/reviews";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deleteReview(id);
        redirAttrs.addFlashAttribute("successMessage", "Avis supprimé avec succès.");
        return "redirect:/reviews";
    }
}

