package com.tgbot.admin.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.tgbot.admin.database.entity.WritingOfficialLetterEntity;
import com.tgbot.admin.database.interfaces.WritingOfficialLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/writing_official_letter")
public class WritingOfficialLetterController {

    @Autowired
    private WritingOfficialLetterRepository writingOfficialLetterRepository;

    private final String bucketName = "bottg";

    @GetMapping
    public List<WritingOfficialLetterEntity> getAllLetters() {
        return writingOfficialLetterRepository.findAll();
    }

    @PostMapping
    public WritingOfficialLetterEntity createLetter(@RequestBody WritingOfficialLetterEntity letter) {
        return writingOfficialLetterRepository.save(letter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WritingOfficialLetterEntity> updateLetter(
            @PathVariable Long id,
            @RequestBody WritingOfficialLetterEntity letterDetails) {
        WritingOfficialLetterEntity letter = writingOfficialLetterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Letter not found with id: " + id));

        letter.setTask(letterDetails.getTask());

        WritingOfficialLetterEntity updatedLetter = writingOfficialLetterRepository.save(letter);
        return ResponseEntity.ok(updatedLetter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLetter(@PathVariable Long id) {
        WritingOfficialLetterEntity letter = writingOfficialLetterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Letter not found with id: " + id));

        writingOfficialLetterRepository.delete(letter);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
