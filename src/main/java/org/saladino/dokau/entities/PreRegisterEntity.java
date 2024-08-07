package org.saladino.dokau.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity @Table @NoArgsConstructor @AllArgsConstructor
public class PreRegisterEntity extends BaseEntity {
    @Column(unique = true)
    private String email;
}
