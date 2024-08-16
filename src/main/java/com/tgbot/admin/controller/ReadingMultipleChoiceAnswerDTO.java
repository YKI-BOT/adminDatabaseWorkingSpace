package com.tgbot.admin.controller;

import lombok.Data;

@Data
public class ReadingMultipleChoiceAnswerDTO {
    private Long id;
    private String text;
    private Long questionId;

    public ReadingMultipleChoiceAnswerDTO(Long id, String text, Long questionId) {
        this.id = id;
        this.text = text;
        this.questionId = questionId;
    }
}

