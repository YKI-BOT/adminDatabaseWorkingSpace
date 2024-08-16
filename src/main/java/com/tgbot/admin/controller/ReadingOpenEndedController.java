package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ReadingOpenEndedEntity;
import com.tgbot.admin.database.interfaces.ReadingOpenEndedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading_open_ended")
public class ReadingOpenEndedController {

    private final ReadingOpenEndedRepository repository;

    @Autowired
    public ReadingOpenEndedController(ReadingOpenEndedRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ReadingOpenEndedEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ReadingOpenEndedEntity create(@RequestBody ReadingOpenEndedEntity question) {
        return repository.save(question);
    }

    @PutMapping("/{id}")
    public ReadingOpenEndedEntity update(@PathVariable Long id, @RequestBody ReadingOpenEndedEntity question) {
        question.setId(id);
        return repository.save(question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

