package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/shows")
    public List<Show> getAll(@RequestParam(required = false) String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return showService.searchShowsByTitle(keyword);
        }
        return showService.getAllShows();
    }
}
