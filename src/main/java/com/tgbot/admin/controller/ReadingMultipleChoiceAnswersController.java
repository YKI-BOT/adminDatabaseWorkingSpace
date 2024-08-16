package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ReadingMultipleChoiceAnswer;
import com.tgbot.admin.database.entity.ReadingMultipleChoiceQuestion;
import com.tgbot.admin.database.interfaces.ReadingMultipleChoiceAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reading_multiple_choice_answers")
public class ReadingMultipleChoiceAnswersController {

    private final ReadingMultipleChoiceAnswerRepository repository;

    @Autowired
    public ReadingMultipleChoiceAnswersController(ReadingMultipleChoiceAnswerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ReadingMultipleChoiceAnswerDTO> getAll() {
        List<ReadingMultipleChoiceAnswer> answers = repository.findAll();
        return answers.stream()
                .map(answer -> new ReadingMultipleChoiceAnswerDTO(
                        answer.getId(),
                        answer.getText(),
                        answer.getQuestion().getId() // Извлекаем только ID вопроса
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ReadingMultipleChoiceAnswerDTO create(@RequestBody ReadingMultipleChoiceAnswer answer) {
        ReadingMultipleChoiceAnswer savedAnswer = repository.save(answer);
        return new ReadingMultipleChoiceAnswerDTO(
                savedAnswer.getId(),
                savedAnswer.getText(),
                savedAnswer.getQuestion().getId()
        );
    }

    @PutMapping("/{id}")
    public ReadingMultipleChoiceAnswerDTO update(@PathVariable Long id, @RequestBody ReadingMultipleChoiceAnswer answer) {
        answer.setId(id);
        ReadingMultipleChoiceAnswer updatedAnswer = repository.save(answer);
        return new ReadingMultipleChoiceAnswerDTO(
                updatedAnswer.getId(),
                updatedAnswer.getText(),
                updatedAnswer.getQuestion().getId()
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
