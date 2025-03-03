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
    private Show show;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToMany(mappedBy = "representations")
    private Set<Reservation> reservations = new HashSet<>();

    private int availableSeats; // Ajout pour les places disponibles
    private double price; // Ajout pour le prix

    // Constructeurs
    public Representation() {}

    public Representation(LocalDateTime schedule, Show show, Location location, int availableSeats, double price) {
        this.schedule = schedule;
        this.show = show;
        this.location = location;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    // Getters & Setters
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

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Representation{" +
                "id=" + id +
                ", schedule=" + schedule +
                ", show=" + show +
                ", location=" + location +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                '}';
    }
}
