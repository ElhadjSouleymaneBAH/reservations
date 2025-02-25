package be.iccbxl.pid.reservations_springboot.api.hateoas;

import be.iccbxl.pid.reservations_springboot.api.controller.ShowApiController;
import be.iccbxl.pid.reservations_springboot.model.Show;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ShowModelAssembler implements RepresentationModelAssembler<Show, EntityModel<Show>> {

    @Override
    public EntityModel<Show> toModel(Show show) {
        return EntityModel.of(show,
                linkTo(methodOn(ShowApiController.class).getShowById(show.getId())).withSelfRel(),
                linkTo(methodOn(ShowApiController.class).getAllShows()).withRel("shows"));
    }
}
