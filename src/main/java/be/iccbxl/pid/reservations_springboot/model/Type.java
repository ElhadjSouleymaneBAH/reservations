package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le type est obligatoire.")
    private String type;

    //  Constructeurs
    public Type() {}

    public Type(String type) {
        this.type = type;
    }

    //  Getters and setters
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    //  toString()
    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
