package be.iccbxl.pid.reservations_springboot.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import be.iccbxl.pid.reservations_springboot.api.hateoas.ArtistModelAssembler;
import be.iccbxl.pid.reservations_springboot.model.Artist;
import be.iccbxl.pid.reservations_springboot.repository.ArtistRepository;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ArtistApiController {

    private final ArtistRepository repository;
    private final ArtistModelAssembler assembler;

    public ArtistApiController(ArtistRepository repository, ArtistModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    //  GET all artists
    @GetMapping("/artists")
    public CollectionModel<EntityModel<Artist>> all() {
        List<EntityModel<Artist>> artists = ((List<Artist>) repository.findAll())
                .stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(artists, linkTo(methodOn(ArtistApiController.class).all()).withSelfRel());
    }

    //  GET a single artist
    @GetMapping("/artists/{id}")
    public EntityModel<Artist> one(@PathVariable Long id) {
        Artist artist = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(" Artist not found with ID: " + id));

        return assembler.toModel(artist);
    }

    //  POST a new artist (validation)
    @PostMapping("/admin/artists")
    public ResponseEntity<?> newArtist(@Valid @RequestBody Artist newArtist) {
        Artist savedArtist = repository.save(newArtist);
        return ResponseEntity
                .created(linkTo(methodOn(ArtistApiController.class).one(savedArtist.getId())).toUri())
                .body(assembler.toModel(savedArtist));
    }

    //  PUT (update) an artist
    @PutMapping("/admin/artists/{id}")
    public ResponseEntity<?> replaceArtist(@Valid @RequestBody Artist newArtist, @PathVariable Long id) {
        Artist updatedArtist = repository.findById(id)
                .map(artist -> {
                    artist.setFirstname(newArtist.getFirstname());
                    artist.setLastname(newArtist.getLastname());
                    return repository.save(artist);
                })
                .orElseGet(() -> {
                    newArtist.setId(id);
                    return repository.save(newArtist);
                });

        return ResponseEntity
                .created(linkTo(methodOn(ArtistApiController.class).one(updatedArtist.getId())).toUri())
                .body(assembler.toModel(updatedArtist));
    }

    //  DELETE an artist
    @DeleteMapping("/admin/artists/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
