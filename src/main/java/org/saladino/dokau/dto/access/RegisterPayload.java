package org.saladino.dokau.dto.access;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import org.saladino.dokau.entities.UserDetailsEntity;
import org.saladino.dokau.entities.UserEntity;

import java.util.Date;

@Getter @Data
public class RegisterPayload {

    @NotEmpty
    @Size(min = 4, max = 13)
    private String username;

    @NotEmpty
    @Size(min = 8, max = 50)
    private String password;

    @NotEmpty
    @Size(min = 4, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 4, max = 100)
    private String lastName;

    @NotNull
    @Past
    private Date birthdate;


    public UserEntity getUser(String email) {
        var user = new UserEntity(username, password, email, false);
        user.setUserDetails(new UserDetailsEntity(firstName, lastName, birthdate));
        return user;
    }
}
