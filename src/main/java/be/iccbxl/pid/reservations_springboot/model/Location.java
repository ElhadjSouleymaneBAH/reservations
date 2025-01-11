package be.iccbxl.pid.reservations_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La désignation ne peut être vide.")
    @Size(min = 2, max = 60, message = "La désignation doit être comprise entre 2 et 60 caractères.")
    private String designation;

    @NotBlank(message = "L'adresse ne peut être vide.")
    @Size(min = 5, max = 255, message = "L'adresse doit être comprise entre 5 et 255 caractères.")
    private String address;

    private String website;
    private String phone;

    public Location() {}

    public Location(String designation, String address, String website, String phone) {
        this.designation = designation;
        this.address = address;
        this.website = website;
        this.phone = phone;
    }

    // Getters et Setters détaillés
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

