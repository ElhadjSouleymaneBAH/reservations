package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The firstname must not be empty.")
    @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.")
    private String firstname;

    @NotBlank(message = "The lastname must not be empty.")
    @Size(min = 2, max = 60, message = "The lastname must be between 2 and 60 characters long.")
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "troupe_id", nullable = true)
    private Troupe troupe;

    // Constructeur protégé pour JPA
    public Artist() {}

    // Constructeur avec paramètres
    public Artist(String firstname, String lastname, Troupe troupe) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.troupe = troupe;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Troupe getTroupe() {
        return troupe;
    }

    public void setTroupe(Troupe troupe) {
        this.troupe = troupe;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", troupe=" + (troupe != null ? troupe.getName() : "none") +
                '}';
    }
}