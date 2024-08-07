package org.saladino.dokau.dto.access;

import jakarta.validation.constraints.*;
import org.saladino.dokau.entities.UserDetailsEntity;
import org.saladino.dokau.entities.UserEntity;

import java.sql.Timestamp;

public class RegisterPayload {

    @NotEmpty
    @Size(min = 4, max = 13)
    private String username;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{8,}$")
    private String password;

    @NotEmpty
    @Size(min = 4, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 4, max = 100)
    private String lastName;

    @NotNull
    @Past
    private Timestamp birthdate;


    public UserEntity getUser(String email) {
        var user = new UserEntity(username, password, email, false);
        user.setUserDetails(new UserDetailsEntity(firstName, lastName, birthdate));
        return user;
    }
}
