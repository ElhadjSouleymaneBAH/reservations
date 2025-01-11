package be.iccbxl.pid.reservations_springboot.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire.")
    @Size(min = 2, max = 255, message = "Le titre doit comporter entre 2 et 255 caractères.")
    private String title;

    @Size(max = 255, message = "L'URL de l'affiche ne peut dépasser 255 caractères.")
    private String posterUrl;

    private int duration;  // Durée en minutes

    private int createdIn;  // Année de création

    private boolean bookable;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;  // Relation ManyToOne avec Location

    // Constructeurs
    public Show() {}

    public Show(String title, String posterUrl, int duration, int createdIn, boolean bookable, Location location) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.duration = duration;
        this.createdIn = createdIn;
        this.bookable = bookable;
        this.location = location;
    }

    // Getters et Setters détaillés
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(int createdIn) {
        this.createdIn = createdIn;
    }

    public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", duration=" + duration +
                ", createdIn=" + createdIn +
                ", bookable=" + bookable +
                ", location=" + location +
                '}';
    }
}

