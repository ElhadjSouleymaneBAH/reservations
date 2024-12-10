package be.iccbxl.pid.reservationsspringboot.controller;

import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping
    public String index(Model model) {
        List<Type> types = service.getAll();
        model.addAttribute("types", types);
        model.addAttribute("title", "Liste des types");
        return "type/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Type type = service.get(id);
        if (type == null) {
            model.addAttribute("errorMessage", "Type introuvable !");
            return "error";
        }
        model.addAttribute("type", type);
        model.addAttribute("title", "Fiche d'un type");
        return "type/show";
    }
}
