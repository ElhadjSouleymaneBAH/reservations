package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private be.iccbxl.pid.reservations_springboot.model.User user;  // Relation ManyToOne avec User

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private be.iccbxl.pid.reservations_springboot.model.Show show;  // Relation ManyToOne avec Show

    @NotBlank(message = "Le contenu du commentaire est obligatoire.")
    @Size(max = 1000, message = "Le contenu du commentaire ne peut dépasser 1000 caractères.")
    private String review;

    @Min(1)
    @Max(5)
    private int stars;  // Note entre 1 et 5 étoiles

    private boolean validated;  // Statut de validation

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructeurs
    public Review() {}

    public Review(be.iccbxl.pid.reservations_springboot.model.User user, be.iccbxl.pid.reservations_springboot.model.Show show, String review, int stars, boolean validated) {
        this.user = user;
        this.show = show;
        this.review = review;
        this.stars = stars;
        this.validated = validated;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters et Setters détaillés
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public be.iccbxl.pid.reservations_springboot.model.User getUser() {
        return user;
    }

    public void setUser(be.iccbxl.pid.reservations_springboot.model.User user) {
        this.user = user;
    }

    public be.iccbxl.pid.reservations_springboot.model.Show getShow() {
        return show;
    }

    public void setShow(be.iccbxl.pid.reservations_springboot.model.Show show) {
        this.show = show;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", show=" + show +
                ", review='" + review + '\'' +
                ", stars=" + stars +
                ", validated=" + validated +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

