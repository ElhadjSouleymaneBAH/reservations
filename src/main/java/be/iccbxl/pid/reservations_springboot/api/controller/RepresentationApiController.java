package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Representation;
import be.iccbxl.pid.reservations_springboot.repository.RepresentationRepository;
import be.iccbxl.pid.reservations_springboot.api.hateoas.RepresentationHateoasAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/representations")
public class RepresentationApiController {

    private final RepresentationRepository repository;
    private final RepresentationHateoasAssembler assembler;

    public RepresentationApiController(RepresentationRepository repository, RepresentationHateoasAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // GET all representations
    @GetMapping
    public CollectionModel<EntityModel<Representation>> getAllRepresentations() {
        List<EntityModel<Representation>> representations = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(representations,
                linkTo(methodOn(RepresentationApiController.class).getAllRepresentations()).withSelfRel());
    }

    // GET a single representation by ID
    @GetMapping("/{id}")
    public EntityModel<Representation> getRepresentationById(@PathVariable Long id) {
        Representation representation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Representation not found"));

        return assembler.toModel(representation);
    }

    // POST a new representation
    @PostMapping
    public ResponseEntity<?> createRepresentation(@RequestBody Representation newRepresentation) {
        Representation savedRepresentation = repository.save(newRepresentation);

        return ResponseEntity
                .created(linkTo(methodOn(RepresentationApiController.class).getRepresentationById(savedRepresentation.getId())).toUri())
                .body(assembler.toModel(savedRepresentation));
    }

    // PUT (update) a representation
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRepresentation(@RequestBody Representation newRepresentation, @PathVariable Long id) {
        Representation updatedRepresentation = repository.findById(id)
                .map(representation -> {
                    representation.setSchedule(newRepresentation.getSchedule());
                    representation.setLocation(newRepresentation.getLocation());
                    representation.setShow(newRepresentation.getShow());
                    return repository.save(representation);
                })
                .orElseGet(() -> {
                    newRepresentation.setId(id);
                    return repository.save(newRepresentation);
                });

        return ResponseEntity
                .created(linkTo(methodOn(RepresentationApiController.class).getRepresentationById(updatedRepresentation.getId())).toUri())
                .body(assembler.toModel(updatedRepresentation));
    }

    // DELETE a representation
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRepresentation(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
