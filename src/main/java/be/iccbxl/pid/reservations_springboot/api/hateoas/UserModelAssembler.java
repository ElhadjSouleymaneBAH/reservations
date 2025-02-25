package be.iccbxl.pid.reservations_springboot.api.hateoas;

import be.iccbxl.pid.reservations_springboot.api.controller.UserApiController;
import be.iccbxl.pid.reservations_springboot.model.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
                linkTo(methodOn(UserApiController.class).getUserById(user.getId())).withSelfRel(),
                linkTo(methodOn(UserApiController.class).getAllUsers()).withRel("users"));
    }
}
