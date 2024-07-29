package org.saladino.dokau.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Table @Entity @Getter @NoArgsConstructor
public class UserDetailsEntity extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column @Temporal(TemporalType.TIMESTAMP)
    private Timestamp birthDate;


}
