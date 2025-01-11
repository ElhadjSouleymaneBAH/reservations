package be.iccbxl.pid.reservations_springboot.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "representation_reservation")
public class RepresentationReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "representation_id", nullable = false)
    private Representation representation;  // Relation ManyToOne avec `Representation`

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;  // Relation ManyToOne avec `Reservation`

    @NotNull(message = "Le prix est obligatoire.")
    private double price;

    @NotNull(message = "La quantité est obligatoire.")
    private int quantity;

    // Constructeurs
    public RepresentationReservation() {}

    public RepresentationReservation(Representation representation, Reservation reservation, double price, int quantity) {
        this.representation = representation;
        this.reservation = reservation;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RepresentationReservation{" +
                "id=" + id +
                ", representation=" + representation +
                ", reservation=" + reservation +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

