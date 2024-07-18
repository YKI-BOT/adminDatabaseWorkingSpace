package com.tgbot.admin.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "listening_true_false", schema = "tasks")
public class ListeningTFEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "audio_id")
    private int audioId;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;
}
