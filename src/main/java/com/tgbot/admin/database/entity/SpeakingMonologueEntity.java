package com.tgbot.admin.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "speaking_monologue", schema = "tasks")
@Data
public class SpeakingMonologueEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "tasks")
    private String tasks;

}
