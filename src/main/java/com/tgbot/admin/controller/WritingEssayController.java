package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.WritingEssayEntity;
import com.tgbot.admin.database.entity.WritingFriendsLetterEntity;
import com.tgbot.admin.database.interfaces.WritingEssayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/writing_essay")
public class WritingEssayController {

    @Autowired
    private WritingEssayRepository writingEssayRepository;

    @GetMapping
    public List<WritingEssayEntity> getAll() {
        return writingEssayRepository.findAll();
    }

    @PostMapping
    public WritingEssayEntity create(@RequestBody WritingEssayEntity reaction) {
        return writingEssayRepository.save(reaction);
    }

    @PutMapping("/{id}")
    public WritingEssayEntity update(@PathVariable Long id, @RequestBody WritingEssayEntity reaction) {
        reaction.setId(id);
        return writingEssayRepository.save(reaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        writingEssayRepository.deleteById(id);
    }
}
