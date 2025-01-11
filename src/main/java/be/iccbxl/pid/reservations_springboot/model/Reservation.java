package be.iccbxl.pid.reservations_springboot.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relation ManyToOne avec User

    @NotNull(message = "La date de réservation est obligatoire.")
    private LocalDateTime bookingDate;

    @NotNull(message = "Le statut est obligatoire.")
    private String status;

    // Constructeurs
    public Reservation() {}

    public Reservation(User user, LocalDateTime bookingDate, String status) {
        this.user = user;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters et Setters détaillés
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                '}';
    }
}
