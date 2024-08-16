package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ReadingMultipleChoiceQuestion;
import com.tgbot.admin.database.interfaces.ReadingMultipleChoiceQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reading_multiple_choice_questions")
public class ReadingMultipleChoiceQuestionsController {

    private final ReadingMultipleChoiceQuestionRepository repository;

    @Autowired
    public ReadingMultipleChoiceQuestionsController(ReadingMultipleChoiceQuestionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ReadingMultipleChoiceQuestionDTO> getAll() {
        List<ReadingMultipleChoiceQuestion> questions = repository.findAll();
        return questions.stream()
                .map(question -> new ReadingMultipleChoiceQuestionDTO(
                        question.getId(),
                        question.getQuestions(),
                        question.getTextId(),
                        question.getCorrectAnswerId()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ReadingMultipleChoiceQuestionDTO create(@RequestBody ReadingMultipleChoiceQuestion question) {
        ReadingMultipleChoiceQuestion savedQuestion = repository.save(question);
        return new ReadingMultipleChoiceQuestionDTO(
                savedQuestion.getId(),
                savedQuestion.getQuestions(),
                savedQuestion.getTextId(),
                savedQuestion.getCorrectAnswerId()
        );
    }

    @PutMapping("/{id}")
    public ReadingMultipleChoiceQuestionDTO update(@PathVariable Long id, @RequestBody ReadingMultipleChoiceQuestion question) {
        question.setId(id);
        ReadingMultipleChoiceQuestion updatedQuestion = repository.save(question);
        return new ReadingMultipleChoiceQuestionDTO(
                updatedQuestion.getId(),
                updatedQuestion.getQuestions(),
                updatedQuestion.getTextId(),
                updatedQuestion.getCorrectAnswerId()
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
