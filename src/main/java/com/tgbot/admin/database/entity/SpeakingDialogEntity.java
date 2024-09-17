package com.tgbot.admin.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "speaking_dialog",schema = "tasks")
@Data
public class SpeakingDialogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "full_task_text")
    String fullTaskText;

    @Column(name = "user_need_to_answer")
    String userNeedToAnswer;

    @Column(name = "dialog_audio_url")
    String dialogAudioUrl;

    @Column(name = "number_of_dialog")
    Long NumberOfDialog;
}

