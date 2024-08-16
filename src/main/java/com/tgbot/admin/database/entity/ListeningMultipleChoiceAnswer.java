package com.tgbot.admin.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "listening_multiple_choice_answers", schema = "tasks")
@Data
public class ListeningMultipleChoiceAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private ListeningMultipleChoiceQuestion question;

    @Column(name = "question_id")
    private Integer questionId;
}