package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.Review;
import be.iccbxl.pid.reservations_springboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    public Review getReview(long id) {
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

    public void updateReview(long id, Review review) {
        repository.save(review);
    }

    public void deleteReview(long id) {
        repository.deleteById(id);
    }
}
