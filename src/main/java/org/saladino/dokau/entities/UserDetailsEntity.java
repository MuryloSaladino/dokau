package org.saladino.dokau.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Table @Entity @Getter @NoArgsConstructor
public class UserDetailsEntity extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column @Temporal(TemporalType.TIMESTAMP)
    private Timestamp birthDate;


    public UserDetailsEntity(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = new Timestamp(birthDate.getTime());
    }


    public void setFirstName(String firstName) {
        this.commitUpdate();
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.commitUpdate();
        this.lastName = lastName;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.commitUpdate();
        this.birthDate = birthDate;
    }
}
