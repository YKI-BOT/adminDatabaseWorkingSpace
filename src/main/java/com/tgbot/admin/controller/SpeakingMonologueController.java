package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.SpeakingMonologueEntity;
import com.tgbot.admin.database.interfaces.SpeakingMonologueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speaking_monologue")
public class SpeakingMonologueController {
    private final SpeakingMonologueRepository speakingMonologueRepository;

    @Autowired
    public SpeakingMonologueController(SpeakingMonologueRepository speakingMonologueRepository) {
        this.speakingMonologueRepository = speakingMonologueRepository;
    }

    @GetMapping
    public List<SpeakingMonologueEntity> getAll() {
        return speakingMonologueRepository.findAll();
    }

    @PostMapping
    public SpeakingMonologueEntity create(@RequestBody SpeakingMonologueEntity monologue) {
        return speakingMonologueRepository.save(monologue);
    }

    @PutMapping("/{id}")
    public SpeakingMonologueEntity update(@PathVariable Long id, @RequestBody SpeakingMonologueEntity monologue) {
        monologue.setId(id);
        return speakingMonologueRepository.save(monologue);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        speakingMonologueRepository.deleteById(id);
    }
}
