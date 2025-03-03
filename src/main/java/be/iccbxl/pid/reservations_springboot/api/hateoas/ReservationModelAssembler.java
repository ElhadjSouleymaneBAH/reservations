package be.iccbxl.pid.reservations_springboot.api.hateoas;

import be.iccbxl.pid.reservations_springboot.api.controller.ReservationApiController;
import be.iccbxl.pid.reservations_springboot.model.Reservation;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReservationModelAssembler implements RepresentationModelAssembler<Reservation, EntityModel<Reservation>> {

    @Override
    public EntityModel<Reservation> toModel(Reservation reservation) {
        return EntityModel.of(reservation,
                linkTo(methodOn(ReservationApiController.class).getReservationById(reservation.getId())).withSelfRel(),
                linkTo(methodOn(ReservationApiController.class).getAllReservations()).withRel("reservations"),
                linkTo(methodOn(ReservationApiController.class).getReservationDetails(reservation.getId())).withRel("details"));
    }
}
