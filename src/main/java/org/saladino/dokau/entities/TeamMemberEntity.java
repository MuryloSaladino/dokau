package org.saladino.dokau.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.saladino.dokau.enums.TeamMemberRole;

@Table @Entity @Getter @NoArgsConstructor
public class TeamMemberEntity extends BaseEntity {

    @ManyToOne @JoinColumn
    private TeamEntity team;

    @ManyToOne @JoinColumn
    private UserEntity user;

    @Column @Enumerated(EnumType.STRING)
    private TeamMemberRole role;


    public TeamMemberEntity(TeamEntity team, UserEntity user, TeamMemberRole role) {
        super();
        this.team = team;
        this.user = user;
        this.role = role;
    }
}
