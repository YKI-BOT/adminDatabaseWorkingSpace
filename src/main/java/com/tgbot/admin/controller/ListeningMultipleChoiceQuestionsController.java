package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ListeningMultipleChoiceQuestion;
import com.tgbot.admin.database.interfaces.ListeningMultipleChoiceQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listening_multiple_choice_questions")
public class ListeningMultipleChoiceQuestionsController {

    private final ListeningMultipleChoiceQuestionRepository repository;

    @Autowired
    public ListeningMultipleChoiceQuestionsController(ListeningMultipleChoiceQuestionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ListeningMultipleChoiceQuestion> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ListeningMultipleChoiceQuestion create(@RequestBody ListeningMultipleChoiceQuestion question) {
        return repository.save(question);
    }

    @PutMapping("/{id}")
    public ListeningMultipleChoiceQuestion update(@PathVariable Long id, @RequestBody ListeningMultipleChoiceQuestion question) {
        question.setId(id);
        return repository.save(question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
