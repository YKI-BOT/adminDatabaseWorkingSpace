package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ReadingTextsEntity;
import com.tgbot.admin.database.interfaces.ReadingTextsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading_texts")
public class ReadingTextsController {

    private final ReadingTextsRepository repository;

    @Autowired
    public ReadingTextsController(ReadingTextsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ReadingTextsEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ReadingTextsEntity create(@RequestBody ReadingTextsEntity text) {
        return repository.save(text);
    }

    @PutMapping("/{id}")
    public ReadingTextsEntity update(@PathVariable Long id, @RequestBody ReadingTextsEntity text) {
        text.setId(id);
        return repository.save(text);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

