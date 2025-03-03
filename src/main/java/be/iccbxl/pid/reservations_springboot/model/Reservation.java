package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de l'utilisateur est obligatoire.")
    private String userName;

    @NotNull(message = "La date de réservation est obligatoire.")
    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status; // Ajout du statut

    @ManyToMany
    @JoinTable(
            name = "reservation_representation",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "representation_id")
    )
    private Set<Representation> representations = new HashSet<>();

    // Constructeurs
    public Reservation() {}

    public Reservation(String userName, LocalDateTime bookingDate, ReservationStatus status) {
        this.userName = userName;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Set<Representation> getRepresentations() {
        return representations;
    }

    public void addRepresentation(Representation representation) {
        this.representations.add(representation);
        representation.getReservations().add(this);
    }

    public void removeRepresentation(Representation representation) {
        this.representations.remove(representation);
        representation.getReservations().remove(this);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                '}';
    }
}
