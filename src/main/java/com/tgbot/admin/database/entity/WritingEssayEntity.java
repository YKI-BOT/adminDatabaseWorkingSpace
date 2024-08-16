package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "writing_essay", schema = "tasks")
@Data
public class WritingEssayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task")
    private String task;
}
