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
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    //  Constructeurs
    public ArtistType() {}

    public ArtistType(Artist artist, Type type) {
        this.artist = artist;
        this.type = type;
    }

    //  Getters
    public Long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public Type getType() {
        return type;
    }

    //  Méthodes pour gérer les relations
    public void addArtist(Artist artist) {
        this.artist = artist;
    }

    public void removeArtist() {
        this.artist = null;
    }

    public void addType(Type type) {
        this.type = type;
    }

    public void removeType() {
        this.type = null;
    }

    //  toString()
    @Override
    public String toString() {
        return "ArtistType{" +
                "id=" + id +
                ", artist=" + (artist != null ? artist.getId() : "null") +
                ", type=" + (type != null ? type.getType() : "null") +
                '}';
    }
}
