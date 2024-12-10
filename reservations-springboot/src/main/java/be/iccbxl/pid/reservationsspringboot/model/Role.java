package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}


