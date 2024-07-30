package org.saladino.dokau.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table @Entity @Getter @NoArgsConstructor
public class TeamEntity extends BaseEntity {

    @Column
    private String name;

    @ManyToOne @JoinColumn()
    private UserEntity owner;


    public TeamEntity(String name) {
        super();
        this.name = name;
    }


    public void setName(String name) {
        this.commitUpdate();
        this.name = name;
    }

    public void setOwner(UserEntity owner) {
        this.commitUpdate();
        this.owner = owner;
    }
}
