package be.iccbxl.pid.reservations_springboot.model;

public class ShowListDTO {
    private Long id;
    private String title;
    private String posterUrl;
    private int duration;
    private String createdIn;
    private boolean bookable;

    public ShowListDTO(Long id, String title, String posterUrl,
                       int duration, String createdIn, boolean bookable) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.duration = duration;
        this.createdIn = createdIn;
        this.bookable = bookable;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getPosterUrl() { return posterUrl; }
    public int getDuration() { return duration; }
    public String getCreatedIn() { return createdIn; }
    public boolean isBookable() { return bookable; }
}
