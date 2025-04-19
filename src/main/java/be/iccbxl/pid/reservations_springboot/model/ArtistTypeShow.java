package be.iccbxl.pid.reservations_springboot.model;


import jakarta.persistence.*;

@Entity
@Table(name = "artist_type_show")
public class ArtistTypeShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_type_id", nullable = false)
    private ArtistType artistType;  // Relation ManyToOne avec `ArtistType`

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private be.iccbxl.pid.reservations_springboot.model.Show show;  // Relation ManyToOne avec `Show`

    // Constructeurs
    public ArtistTypeShow() {}

    public ArtistTypeShow(ArtistType artistType, be.iccbxl.pid.reservations_springboot.model.Show show) {
        this.artistType = artistType;
        this.show = show;
    }

    // Getters et Setters détaillés
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtistType getArtistType() {
        return artistType;
    }

    public void setArtistType(ArtistType artistType) {
        this.artistType = artistType;
    }

    public be.iccbxl.pid.reservations_springboot.model.Show getShow() {
        return show;
    }

    public void setShow(be.iccbxl.pid.reservations_springboot.model.Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "ArtistTypeShow{" +
                "id=" + id +
                ", artistType=" + artistType +
                ", show=" + show +
                '}';
    }
}

