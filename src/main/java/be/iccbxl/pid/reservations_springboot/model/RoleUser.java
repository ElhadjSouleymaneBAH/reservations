package be.iccbxl.pid.reservations_springboot.model;



import jakarta.persistence.*;

@Entity
@Table(name = "role_user")
public class RoleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;  // Relation ManyToOne avec `Role`

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relation ManyToOne avec `User`

    // Constructeurs
    public RoleUser() {}

    public RoleUser(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RoleUser{" +
                "id=" + id +
                ", role=" + role +
                ", user=" + user +
                '}';
    }
}
