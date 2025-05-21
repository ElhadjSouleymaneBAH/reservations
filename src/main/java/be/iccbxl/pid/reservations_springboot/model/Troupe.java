package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "troupes")
public class Troupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name must not be empty.")
    @Size(max = 60, message = "The name must be at most 60 characters long.")
    private String name;

    @NotBlank(message = "The logo URL must not be empty.")
    @Size(max = 255, message = "The logo URL must be at most 255 characters long.")
    @Column(unique = true)
    private String logoUrl;

    // Constructeur par défaut pour JPA
    public Troupe() {}

    // Constructeur avec paramètres
    public Troupe(String name, String logoUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "Troupe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }
}
