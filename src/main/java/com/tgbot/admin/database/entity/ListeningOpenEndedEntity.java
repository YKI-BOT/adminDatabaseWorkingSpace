package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "listening_open_ended", schema = "tasks")
@Data
public class ListeningOpenEndedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "audio_id")
    private Long audioId;

    @Column(name = "question")
    private String question;

    @Column(name = "optional_answer")
    private String optionalAnswer;

    @Column(name = "correct_part_in_audio")
    private String correctPartInAudio;
}
