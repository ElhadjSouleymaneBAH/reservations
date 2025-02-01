package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "representations")
public class Representation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "L'horaire est obligatoire.")
    private LocalDateTime schedule;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private be.iccbxl.pid.reservations_springboot.model.Show show; // Relation ManyToOne avec Show

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location; // Relation ManyToOne avec Location

    @ManyToMany(mappedBy = "representations")
    private Set<Reservation> reservations = new HashSet<>(); // Relation ManyToMany avec Reservation

    // Constructeurs
    public Representation() {}

    public Representation(LocalDateTime schedule, Show show, Location location) {
        this.schedule = schedule;
        this.show = show;
        this.location = location;
    }

    // Getters, setters et méthodes utilitaires
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public be.iccbxl.pid.reservations_springboot.model.Show getShow() {
        return show;
    }

    public void setShow(be.iccbxl.pid.reservations_springboot.model.Show show) {
        this.show = show;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
        reservation.getRepresentations().add(this);
    }

    public void removeReservation(Reservation reservation) {
        this.reservations.remove(reservation);
        reservation.getRepresentations().remove(this);
    }

    @Override
    public String toString() {
        return "Representation{" +
                "id=" + id +
                ", schedule=" + schedule +
                ", show=" + show +
                ", location=" + location +
                '}';
    }
}
