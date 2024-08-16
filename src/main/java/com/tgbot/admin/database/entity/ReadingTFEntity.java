package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reading_true_false_tasks", schema = "tasks")
@Data
public class ReadingTFEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "questions")
    private String question;

    @Column(name = "text_id")
    private Long textId;

    @Column(name = "answers")
    private String answer;
}
