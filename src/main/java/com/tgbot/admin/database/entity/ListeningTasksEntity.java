package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "listening_tasks", schema = "tasks")
public class ListeningTasksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_url")
    private String fileURL;

    @Column(name = "type")
    private String type;
}
