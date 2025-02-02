package be.iccbxl.pid.reservations_springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileUpdateRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String profilePicturePath;

    public UserProfileUpdateRequest() {}

    public UserProfileUpdateRequest(String firstname, String lastname, String email, String password, String profilePicturePath) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.profilePicturePath = profilePicturePath;
    }
}

