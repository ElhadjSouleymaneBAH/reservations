package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.service.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = "*") // Permet les appels depuis le frontend Vue.js
public class ShowApiController {

    private final ShowService showService;

    public ShowApiController(ShowService showService) {
        this.showService = showService;
    }

    //  Obtenir tous les spectacles
    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    //  Obtenir un spectacle par ID
    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Show show = showService.getShow(id);
        if (show == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(show);
    }

    // Recherche de spectacles par titre (si utilisé côté Vue)
    @GetMapping("/search")
    public List<Show> searchShows(@RequestParam("title") String title) {
        return showService.searchShowsByTitle(title);
    }
}
