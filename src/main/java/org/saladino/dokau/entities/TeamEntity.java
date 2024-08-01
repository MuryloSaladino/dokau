package org.saladino.dokau.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table @Entity @Getter @NoArgsConstructor
public class TeamEntity extends BaseEntity {

    @Column
    private String name;

    @ManyToOne @JoinColumn()
    private UserEntity createdBy;


    public TeamEntity(String name) {
        super();
        this.name = name;
    }


    public void setName(String name) {
        this.commitUpdate();
        this.name = name;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.commitUpdate();
        this.createdBy = createdBy;
    }
}
