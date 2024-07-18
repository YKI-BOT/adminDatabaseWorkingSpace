package com.tgbot.admin.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "listening_tasks", schema = "tasks")
public class ListeningTasksEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_url")
    private String fileURL;

    @Column(name = "type")
    private String type;
}
