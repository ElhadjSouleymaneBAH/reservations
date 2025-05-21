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

    @NotBlank
    @Size(min = 2, max = 255)
    private String title;

    @Size(max = 255)
    private String posterUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int duration;
    private Date createdIn;
    private boolean bookable;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "show")
    private List<Representation> representations;

    @ManyToMany
    @JoinTable(
            name = "show_tags",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "price_shows",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "price_id")
    )
    private Set<Price> prices = new HashSet<>();

    // Constructeur par défaut
    public Show() {}

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getDescription() {
        return description;
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

    public List<Representation> getRepresentations() {
        return representations;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    // Méthodes utilitaires pour les tags
    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.getShows().add(this);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
        tag.getShows().remove(this);
    }

    // Méthodes utilitaires pour les prix
    public void addPrice(Price price) {
        this.prices.add(price);
        price.getShows().add(this);
    }

    public void removePrice(Price price) {
        this.prices.remove(price);
        price.getShows().remove(this);
    }
}
