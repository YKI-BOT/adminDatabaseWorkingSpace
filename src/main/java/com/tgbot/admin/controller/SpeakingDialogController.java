package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.SpeakingDialogEntity;
import com.tgbot.admin.database.interfaces.SpeakingDialogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speaking_dialog")
public class SpeakingDialogController {

    private final SpeakingDialogRepository repository;

    @Autowired
    public SpeakingDialogController(SpeakingDialogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SpeakingDialogEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public SpeakingDialogEntity create(@RequestBody SpeakingDialogEntity dialog) {
        return repository.save(dialog);
    }

    @PutMapping("/{id}")
    public SpeakingDialogEntity update(@PathVariable Long id, @RequestBody SpeakingDialogEntity dialog) {
        dialog.setId(id);
        return repository.save(dialog);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
