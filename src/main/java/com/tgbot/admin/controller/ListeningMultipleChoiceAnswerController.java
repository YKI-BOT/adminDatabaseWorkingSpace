package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ListeningMultipleChoiceAnswer;
import com.tgbot.admin.database.interfaces.ListeningMultipleChoiceAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listening_multiple_choice_answers")
public class ListeningMultipleChoiceAnswerController {

    @Autowired
    private ListeningMultipleChoiceAnswerRepository repository;

    @GetMapping
    public List<ListeningMultipleChoiceAnswer> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ListeningMultipleChoiceAnswer getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
    }

    @PostMapping
    public ListeningMultipleChoiceAnswer create(@RequestBody ListeningMultipleChoiceAnswer entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public ListeningMultipleChoiceAnswer update(@PathVariable Long id, @RequestBody ListeningMultipleChoiceAnswer entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}