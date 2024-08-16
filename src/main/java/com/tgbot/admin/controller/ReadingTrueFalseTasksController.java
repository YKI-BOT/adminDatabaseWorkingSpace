package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ReadingTFEntity;
import com.tgbot.admin.database.interfaces.ReadingTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reading_true_false_tasks")
public class ReadingTrueFalseTasksController {

    private final ReadingTFRepository repository;

    @Autowired
    public ReadingTrueFalseTasksController(ReadingTFRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ReadingTFEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ReadingTFEntity create(@RequestBody ReadingTFEntity trueFalse) {
        return repository.save(trueFalse);
    }

    @PutMapping("/{id}")
    public ReadingTFEntity update(@PathVariable Long id, @RequestBody ReadingTFEntity trueFalse) {
        trueFalse.setId(id);
        return repository.save(trueFalse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
