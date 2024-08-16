package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reading_open_ended", schema = "tasks")
public class ReadingOpenEndedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text_id", nullable = false)
    private Long textId;

    @Column(name = "question", nullable = false)
    private String questionText;

    @Column(name = "optional_answer")
    private String optionalAnswer;

    @Column(name = "correct_part_in_text")
    private String correctPartInText;
}
