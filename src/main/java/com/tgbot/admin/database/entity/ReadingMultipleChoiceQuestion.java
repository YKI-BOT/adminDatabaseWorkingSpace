package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "reading_multiple_choice_questions", schema = "tasks")
@Data
public class ReadingMultipleChoiceQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_id")
    private Long textId;

    @Column(name = "questions")
    private String questions;

    @Column(name = "correct_answer_id")
    private Long correctAnswerId;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<ReadingMultipleChoiceAnswer> answers;
}
