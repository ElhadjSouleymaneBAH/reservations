package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Reservation;
import be.iccbxl.pid.reservations_springboot.model.Representation;
import be.iccbxl.pid.reservations_springboot.repository.ReservationRepository;
import be.iccbxl.pid.reservations_springboot.api.hateoas.ReservationModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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

        return CollectionModel.of(reservations,
                linkTo(methodOn(ReservationApiController.class).getAllReservations()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));

        return assembler.toModel(reservation);
    }

    // API pour récupérer les détails de la réservation (avec spectacles, places et prix)
    @GetMapping("/{id}/details")
    public ResponseEntity<?> getReservationDetails(@PathVariable Long id) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));

        Map<String, Object> response = new HashMap<>();
        response.put("id", reservation.getId());
        response.put("userName", reservation.getUserName());
        response.put("bookingDate", reservation.getBookingDate());
        response.put("status", reservation.getStatus());

        // Ajouter les spectacles réservés
        List<Map<String, Object>> representations = reservation.getRepresentations().stream()
                .map(representation -> {
                    Map<String, Object> repDetails = new HashMap<>();
                    repDetails.put("spectacle", representation.getShow().getTitle());
                    repDetails.put("date", representation.getSchedule());
                    repDetails.put("places", representation.getAvailableSeats());
                    repDetails.put("prix", representation.getPrice());
                    return repDetails;
                }).collect(Collectors.toList());

        response.put("representations", representations);

        return ResponseEntity.ok(response);
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
