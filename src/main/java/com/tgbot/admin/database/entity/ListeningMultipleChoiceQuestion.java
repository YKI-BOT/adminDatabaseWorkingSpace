package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "listening_multiple_choice_questions", schema = "tasks")
@Data
public class ListeningMultipleChoiceQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @Column(name = "audio_id")
    private Long audioId;

    @Column(name = "correct_answer_id")
    private Long correctAnswerId;
}
