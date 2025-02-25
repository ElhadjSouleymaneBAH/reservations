package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Reservation;
import be.iccbxl.pid.reservations_springboot.repository.ReservationRepository;
import be.iccbxl.pid.reservations_springboot.api.hateoas.ReservationModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationRepository repository;
    private final ReservationModelAssembler assembler;

    public ReservationApiController(ReservationRepository repository, ReservationModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Reservation>> getAllReservations() {
        List<EntityModel<Reservation>> reservations = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(reservations, linkTo(methodOn(ReservationApiController.class).getAllReservations()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));

        return assembler.toModel(reservation);
    }

    // Récupérer les réservations d’un utilisateur
    @GetMapping("/user/{userId}")
    public CollectionModel<EntityModel<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        List<EntityModel<Reservation>> reservations = repository.findByUserId(userId).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(reservations, linkTo(methodOn(ReservationApiController.class).getReservationsByUser(userId)).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation newReservation) {
        Reservation savedReservation = repository.save(newReservation);
        return ResponseEntity
                .created(linkTo(methodOn(ReservationApiController.class).getReservationById(savedReservation.getId())).toUri())
                .body(assembler.toModel(savedReservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
