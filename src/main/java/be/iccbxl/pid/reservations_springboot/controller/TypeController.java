package be.iccbxl.pid.reservations_springboot.controller;


import be.iccbxl.pid.reservations_springboot.model.Type;
import be.iccbxl.pid.reservations_springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String index(Model model) {
        model.addAttribute("types", typeService.getAllTypes());
        return "type/index";
    }

    @GetMapping("/types/create")
    public String create(Model model) {
        model.addAttribute("type", new Type());
        return "type/create";
    }

    @PostMapping("/types/create")
    public String store(@ModelAttribute Type type, RedirectAttributes redirAttrs) {
        typeService.addType(type);
        redirAttrs.addFlashAttribute("successMessage", "Type ajouté avec succès.");
        return "redirect:/types";
    }

    @GetMapping("/types/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "type/edit";
    }

    @PutMapping("/types/{id}/edit")
    public String update(@ModelAttribute Type type, @PathVariable long id, RedirectAttributes redirAttrs) {
        typeService.updateType(id, type);
        redirAttrs.addFlashAttribute("successMessage", "Type modifié avec succès.");
        return "redirect:/types";
    }

    @DeleteMapping("/types/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirAttrs) {
        typeService.deleteType(id);
        redirAttrs.addFlashAttribute("successMessage", "Type supprimé.");
        return "redirect:/types";
    }
}
