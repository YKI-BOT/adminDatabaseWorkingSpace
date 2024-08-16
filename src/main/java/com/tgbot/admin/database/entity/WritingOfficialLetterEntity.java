package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "writing_official_letter", schema = "tasks")
@Data
public class WritingOfficialLetterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "task")
    String task;
}
