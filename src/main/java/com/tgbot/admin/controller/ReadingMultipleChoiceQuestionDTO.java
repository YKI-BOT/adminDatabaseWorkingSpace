package com.tgbot.admin.controller;

import lombok.Data;

@Data
public class ReadingMultipleChoiceQuestionDTO {
    private Long id;
    private String text;
    private Long audioId;
    private Long correctAnswerId;

    public ReadingMultipleChoiceQuestionDTO(Long id, String text, Long audioId, Long correctAnswerId) {
        this.id = id;
        this.text = text;
        this.audioId = audioId;
        this.correctAnswerId = correctAnswerId;
    }
}

