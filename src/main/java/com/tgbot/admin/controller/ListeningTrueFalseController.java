package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ListeningTFEntity;
import com.tgbot.admin.database.interfaces.ListeningTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listening_true_false")
public class ListeningTrueFalseController {

    private final ListeningTFRepository repository;

    @Autowired
    public ListeningTrueFalseController(ListeningTFRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ListeningTFEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ListeningTFEntity create(@RequestBody ListeningTFEntity trueFalse) {
        return repository.save(trueFalse);
    }

    @PutMapping("/{id}")
    public ListeningTFEntity update(@PathVariable Long id, @RequestBody ListeningTFEntity trueFalse) {
        trueFalse.setId(id);
        return repository.save(trueFalse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}