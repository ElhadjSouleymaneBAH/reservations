package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String city;

    @ManyToOne
    @JoinColumn(name = "locality_id", nullable = false)
    private Locality locality; // Relation ManyToOne avec Locality

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Representation> representations; // Relation OneToMany avec Representation

    // Getter pour locality
    public Locality getLocality() {
        return locality;
    }

    // Setter pour locality
    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    // Méthodes utilitaires pour OneToMany avec Representation
    public void addRepresentation(Representation representation) {
        this.representations.add(representation);
        representation.setLocation(this);
    }

    public void removeRepresentation(Representation representation) {
        this.representations.remove(representation);
        representation.setLocation(null);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", locality=" + locality +
                '}';
    }
}
