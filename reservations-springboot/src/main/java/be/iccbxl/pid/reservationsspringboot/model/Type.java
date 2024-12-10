package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String type;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Artist> artists;
}

