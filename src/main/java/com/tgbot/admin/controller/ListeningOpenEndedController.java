package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ListeningOpenEndedEntity;
import com.tgbot.admin.database.interfaces.ListeningOpenEndedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listening_open_ended")
public class ListeningOpenEndedController {

    private final ListeningOpenEndedRepository repository;

    @Autowired
    public ListeningOpenEndedController(ListeningOpenEndedRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ListeningOpenEndedEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ListeningOpenEndedEntity create(@RequestBody ListeningOpenEndedEntity openEnded) {
        return repository.save(openEnded);
    }

    @PutMapping("/{id}")
    public ListeningOpenEndedEntity update(@PathVariable Long id, @RequestBody ListeningOpenEndedEntity openEnded) {
        openEnded.setId(id);
        return repository.save(openEnded);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
