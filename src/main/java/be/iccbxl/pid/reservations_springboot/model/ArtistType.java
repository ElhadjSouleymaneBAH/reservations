package be.iccbxl.pid.reservations_springboot.model;


import jakarta.persistence.*;

@Entity
@Table(name = "artist_type")
public class ArtistType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;  // Relation ManyToOne avec `Artist`

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;  // Relation ManyToOne avec `Type`

    // Constructeurs
    public ArtistType() {}

    public ArtistType(Artist artist, Type type) {
        this.artist = artist;
        this.type = type;
    }

    // Getters et Setters détaillés
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ArtistType{" +
                "id=" + id +
                ", artist=" + artist +
                ", type=" + type +
                '}';
    }
}

