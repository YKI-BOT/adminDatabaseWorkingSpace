package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.SpeakingReactionEntity;
import com.tgbot.admin.database.interfaces.SpeakingReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speaking_reaction")
public class SpeakingReactionController {

    @Autowired
    private SpeakingReactionRepository speakingReactionRepository;

    @GetMapping
    public List<SpeakingReactionEntity> getAll() {
        return speakingReactionRepository.findAll();
    }

    @PostMapping
    public SpeakingReactionEntity create(@RequestBody SpeakingReactionEntity reaction) {
        return speakingReactionRepository.save(reaction);
    }

    @PutMapping("/{id}")
    public SpeakingReactionEntity update(@PathVariable Long id, @RequestBody SpeakingReactionEntity reaction) {
        reaction.setId(id);
        return speakingReactionRepository.save(reaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        speakingReactionRepository.deleteById(id);
    }
}

