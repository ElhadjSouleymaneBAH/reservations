package be.iccbxl.pid.reservations_springboot.controller;


import be.iccbxl.pid.reservations_springboot.model.Price;
import be.iccbxl.pid.reservations_springboot.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    PriceService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("prices", service.getAllPrices());
        return "price/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("price", service.getPrice(id));
        return "price/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("price", new Price());
        return "price/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Price price, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "price/create";
        }
        service.addPrice(price);
        redirAttrs.addFlashAttribute("successMessage", "Prix ajouté avec succès.");
        return "redirect:/prices";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("price", service.getPrice(id));
        return "price/edit";
    }

    @PutMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Price price, BindingResult bindingResult, @PathVariable long id, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            return "price/edit";
        }
        service.updatePrice(id, price);
        redirAttrs.addFlashAttribute("successMessage", "Prix mis à jour avec succès.");
        return "redirect:/prices";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        service.deletePrice(id);
        redirAttrs.addFlashAttribute("successMessage", "Prix supprimé avec succès.");
        return "redirect:/prices";
    }
}
