package org.saladino.dokau.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table @Entity @Getter @NoArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(unique=true)
    private String username;

    @Column
    private String password;

    @Column(unique=true)
    private String email;

    @Column
    private Boolean admin;

    @OneToOne @MapsId
    private UserDetailsEntity userDetails;


    public UserEntity(String username, String password, String email, Boolean admin) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.admin = admin;
    }


    public void setPassword(String password) {
        this.commitUpdate();
        this.password = password;
    }

    public void setUsername(String username) {
        this.commitUpdate();
        this.username = username;
    }

    public void setEmail(String email) {
        this.commitUpdate();
        this.email = email;
    }
}
