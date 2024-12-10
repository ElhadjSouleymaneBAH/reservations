package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "localities")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postal_code", nullable = false, unique = true)
    private String postalCode;

    @Column(nullable = false)
    private String locality;
}


