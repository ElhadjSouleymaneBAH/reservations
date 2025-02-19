package be.iccbxl.pid.reservations_springboot.api.hateoas;

import be.iccbxl.pid.reservations_springboot.api.controller.RepresentationApiController;
import be.iccbxl.pid.reservations_springboot.model.Representation;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RepresentationHateoasAssembler implements RepresentationModelAssembler<Representation, EntityModel<Representation>> {

    @Override
    public EntityModel<Representation> toModel(Representation representation) {
        return EntityModel.of(representation,
                linkTo(methodOn(RepresentationApiController.class).getRepresentationById(representation.getId())).withSelfRel(),
                linkTo(methodOn(RepresentationApiController.class).getAllRepresentations()).withRel("representations"));
    }
}
