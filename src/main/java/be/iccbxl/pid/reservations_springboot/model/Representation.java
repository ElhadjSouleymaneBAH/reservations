package be.iccbxl.pid.reservations_springboot.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

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
    private Show show;  // Relation ManyToOne avec Show

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;  // Relation ManyToOne avec Location

    // Constructeurs
    public Representation() {}

    public Representation(LocalDateTime schedule, Show show, Location location) {
        this.schedule = schedule;
        this.show = show;
        this.location = location;
    }

    // Getters et Setters détaillés
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

