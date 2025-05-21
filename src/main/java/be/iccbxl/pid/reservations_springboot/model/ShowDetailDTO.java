package be.iccbxl.pid.reservations_springboot.model;

import java.util.Set;

public class ShowDetailDTO {
    private Long id;
    private String title;
    private String posterUrl;
    private String description;
    private int duration;
    private boolean bookable;
    private String locationDesignation;
    private Set<String> tags;
    private String createdIn;

    public ShowDetailDTO(Long id, String title, String posterUrl,
                         String description, int duration, boolean bookable,
                         String locationDesignation, Set<String> tags,
                         String createdIn) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.description = description;
        this.duration = duration;
        this.bookable = bookable;
        this.locationDesignation = locationDesignation;
        this.tags = tags;
        this.createdIn = createdIn;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getPosterUrl() { return posterUrl; }
    public String getDescription() { return description; }
    public int getDuration() { return duration; }
    public boolean isBookable() { return bookable; }
    public String getLocationDesignation() { return locationDesignation; }
    public Set<String> getTags() { return tags; }
    public String getCreatedIn() { return createdIn; }
}
