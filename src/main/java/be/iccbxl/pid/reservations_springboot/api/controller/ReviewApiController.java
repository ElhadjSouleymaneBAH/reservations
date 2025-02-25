package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Review;
import be.iccbxl.pid.reservations_springboot.service.ReviewService;
import be.iccbxl.pid.reservations_springboot.api.hateoas.ReviewModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewApiController {

    private final ReviewService reviewService;
    private final ReviewModelAssembler assembler;

    public ReviewApiController(ReviewService reviewService, ReviewModelAssembler assembler) {
        this.reviewService = reviewService;
        this.assembler = assembler;
    }

    //  Récupérer tous les commentaires
    @GetMapping
    public CollectionModel<EntityModel<Review>> getAllReviews() {
        List<EntityModel<Review>> reviews = reviewService.getAllReviews().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(reviews, linkTo(methodOn(ReviewApiController.class).getAllReviews()).withSelfRel());
    }

    // Récupérer un commentaire par ID
    @GetMapping("/{id}")
    public EntityModel<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReview(id);
        return assembler.toModel(review);
    }

    // Récupérer les commentaires d’un utilisateur
    @GetMapping("/user/{userId}")
    public CollectionModel<EntityModel<Review>> getReviewsByUser(@PathVariable Long userId) {
        List<EntityModel<Review>> reviews = reviewService.getReviewsByUserId(userId).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(reviews, linkTo(methodOn(ReviewApiController.class).getReviewsByUser(userId)).withSelfRel());
    }

    // Récupérer les commentaires d’un spectacle (seulement ceux validés)
    @GetMapping("/show/{showId}")
    public CollectionModel<EntityModel<Review>> getReviewsByShow(@PathVariable Long showId) {
        List<EntityModel<Review>> reviews = reviewService.getReviewsByShowId(showId).stream()
                .filter(Review::isValidated)
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(reviews, linkTo(methodOn(ReviewApiController.class).getReviewsByShow(showId)).withSelfRel());
    }

    //  Ajouter un commentaire (non validé par défaut)
    @PostMapping
    public ResponseEntity<?> createReview(@Valid @RequestBody Review review) {
        review.setValidated(false);
        reviewService.addReview(review);
        return ResponseEntity.ok(assembler.toModel(review));
    }

    //  Supprimer un commentaire
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
