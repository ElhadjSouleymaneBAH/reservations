package be.iccbxl.pid.reservations_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import be.iccbxl.pid.reservations_springboot.model.Representation;
import be.iccbxl.pid.reservations_springboot.service.RepresentationService;

import java.util.List;

@Controller
@RequestMapping("/representations")
public class RepresentationController {
    @Autowired
    private RepresentationService representationService;

    @GetMapping
    public String index(Model model) {
        List<Representation> representations = representationService.getAllRepresentations();
        model.addAttribute("representations", representations);
        return "representation/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Representation representation = representationService.getRepresentationById(id);
        if (representation == null) {
            return "redirect:/representations";
        }
        model.addAttribute("representation", representation);
        return "representation/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("representation", new Representation());
        return "representation/create";
    }

    @PostMapping
    public String store(@ModelAttribute Representation representation) {
        representationService.saveRepresentation(representation);
        return "redirect:/representations";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Representation representation = representationService.getRepresentationById(id);
        if (representation == null) {
            return "redirect:/representations";
        }
        model.addAttribute("representation", representation);
        return "representation/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Representation representation) {
        representationService.saveRepresentation(representation);
        return "redirect:/representations";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        representationService.deleteRepresentation(id);
        return "redirect:/representations";
    }
}
