package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Type;

@Entity
@Table(name = "speaking_reaction", schema = "tasks")
@Data
public class SpeakingReactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task")
    private String task;
}
