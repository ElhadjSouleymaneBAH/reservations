package be.iccbxl.pid.reservations_springboot.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le prénom ne doit pas être vide.")
    @Size(min = 2, max = 60, message = "Le prénom doit contenir entre 2 et 60 caractères.")
    private String firstname;

    @NotBlank(message = "Le nom de famille ne doit pas être vide.")
    @Size(min = 2, max = 60, message = "Le nom de famille doit contenir entre 2 et 60 caractères.")
    private String lastname;

    protected Artist() {
        // Constructeur par défaut requis pour JPA
    }

    public Artist(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Getters et Setters
    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return String.format("%s %s", firstname, lastname);
    }
}

