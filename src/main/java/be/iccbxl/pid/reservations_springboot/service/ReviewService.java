package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.Review;
import be.iccbxl.pid.reservations_springboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    public Optional<Review> getReview(long id) {
        return repository.findById(id);
    }

    public List<Review> getReviewsByUserId(long userId) {
        return repository.findByUserId(userId);
    }

    public List<Review> getReviewsByShowId(long showId) {
        return repository.findByShowId(showId);
    }

    public void addReview(Review review) {
        repository.save(review);
    }

    public boolean updateReview(long id, Review review) {
        return repository.findById(id).map(existingReview -> {
            existingReview.setReview(review.getReview());
            existingReview.setStars(review.getStars());
            existingReview.setValidated(review.isValidated());
            repository.save(existingReview);
            return true;
        }).orElse(false);
    }

    public boolean deleteReview(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
