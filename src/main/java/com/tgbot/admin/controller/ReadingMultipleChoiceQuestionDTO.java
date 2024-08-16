package com.tgbot.admin.controller;

import lombok.Data;

@Data
public class ReadingMultipleChoiceQuestionDTO {
    private Long id;
    private String text;
    private Long textId;
    private Long correctAnswerId;

    public ReadingMultipleChoiceQuestionDTO(Long id, String text, Long textId, Long correctAnswerId) {
        this.id = id;
        this.text = text;
        this.textId = textId;
        this.correctAnswerId = correctAnswerId;
    }
}

