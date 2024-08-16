package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "reading_multiple_choice_answers", schema = "tasks")
@Data
public class ReadingMultipleChoiceAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private ReadingMultipleChoiceQuestion question;
}
