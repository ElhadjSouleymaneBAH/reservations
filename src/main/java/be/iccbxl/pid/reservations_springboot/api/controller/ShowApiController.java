package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.model.ShowListDTO;
import be.iccbxl.pid.reservations_springboot.model.ShowDetailDTO;
import be.iccbxl.pid.reservations_springboot.service.ShowService;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = "*")
public class ShowApiController {

    private final ShowService showService;
    private final SimpleDateFormat yearFmt = new SimpleDateFormat("yyyy");
    private final SimpleDateFormat fullFmt = new SimpleDateFormat("yyyy-MM-dd");

    public ShowApiController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<ShowListDTO> getAllOrSearch(@RequestParam(required = false) String keyword) {
        List<Show> shows = (keyword != null && !keyword.isEmpty())
                ? showService.searchShowsByTitle(keyword)
                : showService.getAllShows();

        return shows.stream()
                .map(sh -> new ShowListDTO(
                        sh.getId(),
                        sh.getTitle(),
                        sh.getPosterUrl(),
                        sh.getDuration(),
                        yearFmt.format(sh.getCreatedIn()),
                        sh.isBookable()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ShowDetailDTO getOne(@PathVariable Long id) {
        Show sh = showService.getShow(id);
        if (sh == null) {
            return null;
        }

        Set<String> tagLabels = sh.getTags().stream()
                .map(Tag -> Tag.getTag())
                .collect(Collectors.toSet());

        return new ShowDetailDTO(
                sh.getId(),
                sh.getTitle(),
                sh.getPosterUrl(),
                sh.getDescription(),
                sh.getDuration(),
                sh.isBookable(),
                sh.getLocation().getDesignation(),
                tagLabels,
                fullFmt.format(sh.getCreatedIn())
        );
    }
}
