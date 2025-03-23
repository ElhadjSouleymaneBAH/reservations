package be.iccbxl.pid.reservations_springboot.api.controller;

import be.iccbxl.pid.reservations_springboot.model.Review;
import be.iccbxl.pid.reservations_springboot.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*") // autorise les appels depuis le frontend (Vue.js)
public class ReviewApiController {

    private final ReviewRepository reviewRepository;

    public ReviewApiController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    //  Créer un commentaire
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        review.setValidated(false); // par défaut, commentaire non validé
        return reviewRepository.save(review);
    }

    //  Récupérer tous les commentaires validés
    @GetMapping
    public List<Review> getValidatedReviews() {
        return reviewRepository.findAll()
                .stream()
                .filter(Review::isValidated)
                .toList();
    }

    //  Récupérer les commentaires validés pour un spectacle donné
    @GetMapping("/show/{showId}")
    public List<Review> getReviewsByShow(@PathVariable Long showId) {
        return reviewRepository.findByShowId(showId)
                .stream()
                .filter(Review::isValidated)
                .toList();
    }

    //  Récupérer tous les commentaires (admin/modération)
    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    //  Valider un commentaire (modération)
    @PutMapping("/{id}/validate")
    public Review validateReview(@PathVariable Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));
        review.setValidated(true);
        return reviewRepository.save(review);
    }

    //  Supprimer un commentaire
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Commentaire non trouvé");
        }
        reviewRepository.deleteById(id);
    }
}
