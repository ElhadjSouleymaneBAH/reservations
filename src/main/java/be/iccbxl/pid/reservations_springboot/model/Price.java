package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le type de prix est obligatoire.")
    private String type;

    @NotNull(message = "Le montant est obligatoire.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le prix doit être supérieur à 0.")
    private double price;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany(mappedBy = "prices")
    private Set<be.iccbxl.pid.reservations_springboot.model.Show> shows = new HashSet<>(); // Relation ManyToMany avec Show

    // Constructeurs
    public Price() {}

    public Price(String type, double price, LocalDate startDate, LocalDate endDate) {
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<be.iccbxl.pid.reservations_springboot.model.Show> getShows() {
        return shows;
    }

    // Méthodes utilitaires pour ManyToMany avec Show
    public void addShow(be.iccbxl.pid.reservations_springboot.model.Show show) {
        this.shows.add(show);
        show.getPrices().add(this);
    }

    public void removeShow(be.iccbxl.pid.reservations_springboot.model.Show show) {
        this.shows.remove(show);
        show.getPrices().remove(this);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
