package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.WritingFriendsLetterEntity;
import com.tgbot.admin.database.interfaces.WritingFriendsLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/writing_friend_letter")
public class WritingFriendLetterController {

    @Autowired
    private WritingFriendsLetterRepository writingFriendsLetterRepository;

    @GetMapping
    public List<WritingFriendsLetterEntity> getAll() {
        return writingFriendsLetterRepository.findAll();
    }

    @PostMapping
    public WritingFriendsLetterEntity create(@RequestBody WritingFriendsLetterEntity reaction) {
        return writingFriendsLetterRepository.save(reaction);
    }

    @PutMapping("/{id}")
    public WritingFriendsLetterEntity update(@PathVariable Long id, @RequestBody WritingFriendsLetterEntity reaction) {
        reaction.setId(id);
        return writingFriendsLetterRepository.save(reaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        writingFriendsLetterRepository.deleteById(id);
    }
}
