package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Show;
import be.iccbxl.pid.reservations_springboot.service.ShowService;
import be.iccbxl.pid.reservations_springboot.api.hateoas.ShowModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/shows")
public class ShowApiController {

    private final ShowService service;
    private final ShowModelAssembler assembler;

    public ShowApiController(ShowService service, ShowModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Show>> getAllShows() {
        List<EntityModel<Show>> shows = service.getAllShows().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(shows, linkTo(methodOn(ShowApiController.class).getAllShows()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Show> getShowById(@PathVariable Long id) {
        Show show = service.getShow(id);
        return assembler.toModel(show);
    }

    @PostMapping
    public ResponseEntity<?> createShow(@RequestBody Show newShow) {
        Show savedShow = service.getShow(newShow.getId());
        return ResponseEntity
                .created(linkTo(methodOn(ShowApiController.class).getShowById(savedShow.getId())).toUri())
                .body(assembler.toModel(savedShow));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShow(@PathVariable Long id) {
        service.deleteShow(id);
        return ResponseEntity.noContent().build();
    }
}
