package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.model.ShowDTO;
import be.iccbxl.pid.reservations_springboot.service.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = "*")
public class ShowApiController {

    private final ShowService showService;

    public ShowApiController(ShowService showService) {
        this.showService = showService;
    }

    // GET /api/shows?keyword=musique
    @GetMapping
    public List<ShowDTO> getAllOrSearch(@RequestParam(required = false) String keyword) {
        List<Show> shows = (keyword != null && !keyword.isEmpty())
                ? showService.searchShowsByTitle(keyword)
                : showService.getAllShows();

        return shows.stream()
                .map(show -> new ShowDTO(show.getId(), show.getTitle(), show.getPosterUrl()))
                .collect(Collectors.toList());
    }

    // GET /api/shows/1
    @GetMapping("/{id}")
    public ShowDTO getOne(@PathVariable Long id) {
        Show show = showService.getShow(id);
        return (show != null)
                ? new ShowDTO(show.getId(), show.getTitle(), show.getPosterUrl())
                : null;
    }
}
