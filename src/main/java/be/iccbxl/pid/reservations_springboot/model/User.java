package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String langue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private be.iccbxl.pid.reservations_springboot.model.UserRole role;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // Constructeur pratique
    public User(String login, String password, String firstname, String lastname, String email, String langue, UserRole role) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.langue = langue;
        this.role = role;
    }

    // Ajout et suppression de rôles
    public void addRole(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", langue='" + langue + '\'' +
                ", role=" + role +
                ", roles=" + roles +
                ", createdAt=" + createdAt +
                '}';
    }
}
