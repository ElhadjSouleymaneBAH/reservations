package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "localities")
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postalCode;
    private String locality;

    @OneToMany(mappedBy = "locality", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Location> locations = new HashSet<>();

    // Constructeurs
    public Locality() {}

    public Locality(String postalCode, String locality) {
        this.postalCode = postalCode;
        this.locality = locality;
    }

    // Getters uniquement (pas de setter pour la collection)
    public Long getId() {
        return id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    // Méthodes utilitaires pour OneToMany
    public void addLocation(Location location) {
        if (!this.locations.contains(location)) {
            this.locations.add(location);
            location.setLocality(this);
        }
    }

    public void removeLocation(Location location) {
        if (this.locations.contains(location)) {
            this.locations.remove(location);
            if (location.getLocality() == this) {
                location.setLocality(null);
            }
        }
    }

    // Override toString
    @Override
    public String toString() {
        return "Locality{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", locality='" + locality + '\'' +
                ", locations=" + locations.size() +
                '}';
    }
}
