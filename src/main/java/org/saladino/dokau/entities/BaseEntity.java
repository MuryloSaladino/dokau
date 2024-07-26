package org.saladino.dokau.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@MappedSuperclass @Getter
public class BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column() @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column() @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;

    @Column() @Temporal(TemporalType.TIMESTAMP) @Setter
    private Timestamp deletedAt;

    protected BaseEntity() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        this.deletedAt = null;
    }

    protected void commitUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
