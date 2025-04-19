package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
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
    private Date createdIn;
    private boolean bookable;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "show")
    private List<Representation> representations;

    @OneToMany(mappedBy = "show")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
            name = "price_shows",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "price_id")
    )
    private Set<Price> prices = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "show_tags",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    public Show() {}

    public Show(String title, String posterUrl, int duration, Date createdIn, boolean bookable, Location location) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.duration = duration;
        this.createdIn = createdIn;
        this.bookable = bookable;
        this.location = location;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public int getDuration() {
        return duration;
    }

    public Date getCreatedIn() {
        return createdIn;
    }

    public boolean isBookable() {
        return bookable;
    }

    public Location getLocation() {
        return location;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    // Price management
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

    // Tag management
    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.getShows().add(this);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
        tag.getShows().remove(this);
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
