package be.iccbxl.pid.reservations_springboot.model;

public class ShowDTO {
    private Long id;
    private String title;
    private String description;

    public ShowDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
