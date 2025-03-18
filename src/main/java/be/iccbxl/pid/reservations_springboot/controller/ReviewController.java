package be.iccbxl.pid.reservations_springboot.controller;

import be.iccbxl.pid.reservations_springboot.model.Review;
import be.iccbxl.pid.reservations_springboot.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService service;

    @GetMapping
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    @GetMapping("/{id}")
    public Optional<Review> getReview(@PathVariable long id) {
        return service.getReview(id);
    }

    @PostMapping("/create")
    public String addReview(@RequestBody Review review) {
        service.addReview(review);
        return "Review added successfully!";
    }

    @PutMapping("/{id}/edit")
    public String updateReview(@PathVariable long id, @RequestBody Review review) {
        boolean updated = service.updateReview(id, review);
        return updated ? "Review updated successfully!" : "Review not found.";
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable long id) {
        boolean deleted = service.deleteReview(id);
        return deleted ? "Review deleted successfully!" : "Review not found.";
    }
}
