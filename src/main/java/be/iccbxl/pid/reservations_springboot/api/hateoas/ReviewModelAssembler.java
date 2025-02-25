package be.iccbxl.pid.reservations_springboot.api.hateoas;

import be.iccbxl.pid.reservations_springboot.api.controller.ReviewApiController;
import be.iccbxl.pid.reservations_springboot.model.Review;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReviewModelAssembler implements RepresentationModelAssembler<Review, EntityModel<Review>> {

    @Override
    public EntityModel<Review> toModel(Review review) {
        return EntityModel.of(review,
                linkTo(methodOn(ReviewApiController.class).getReviewById(review.getId())).withSelfRel(),
                linkTo(methodOn(ReviewApiController.class).getReviewsByShow(review.getShow().getId())).withRel("show-reviews"),
                linkTo(methodOn(ReviewApiController.class).getReviewsByUser(review.getUser().getId())).withRel("user-reviews"));
    }
}
