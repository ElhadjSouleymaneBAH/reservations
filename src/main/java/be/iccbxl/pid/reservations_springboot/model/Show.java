package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private int duration;
    private int createdIn;
    private boolean bookable;

    @OneToMany(mappedBy = "show")
    private List<Representation> representations;

    @OneToMany(mappedBy = "show")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToMany
    @JoinTable(
            name = "show_price",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "price_id")
    )
    private Set<Price> prices = new HashSet<>();

    public Show() {}

    public Show(String title, String posterUrl, int duration, int createdIn, boolean bookable, Location location) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.duration = duration;
        this.createdIn = createdIn;
        this.bookable = bookable;
        this.location = location;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getPosterUrl() { return posterUrl; }
    public int getDuration() { return duration; }
    public int getCreatedIn() { return createdIn; }
    public boolean isBookable() { return bookable; }
    public Location getLocation() { return location; }
    public Set<Price> getPrices() { return prices; }

    public void addPrice(Price price) {
        if (!this.prices.contains(price)) {
            this.prices.add(price);
            price.getShows().add(this);
        }
    }

    public void removePrice(Price price) {
        if (this.prices.contains(price)) {
            this.prices.remove(price);
            price.getShows().remove(this);
        }
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
                ", prices=" + prices +
                '}';
    }
}
