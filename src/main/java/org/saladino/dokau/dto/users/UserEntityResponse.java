package org.saladino.dokau.dto.users;

import org.saladino.dokau.entities.UserEntity;

import java.sql.Timestamp;

public class UserEntityResponse {

    public Long id;
    public String username;
    public String email;
    public String name;
    public Timestamp birthDate;

    public UserEntityResponse(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.name = user.getUserDetails().getFirstName() + " " + user.getUserDetails().getLastName();
        this.birthDate = user.getUserDetails().getBirthDate();
    }
}
