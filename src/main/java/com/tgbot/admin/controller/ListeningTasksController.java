package com.tgbot.admin.controller;

import com.tgbot.admin.database.entity.ListeningTasksEntity;
import com.tgbot.admin.database.interfaces.ListeningTasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/listening_tasks")
public class ListeningTasksController {

    @Autowired
    private ListeningTasksRepository listeningTasksRepository;

    @GetMapping
    public List<ListeningTasksEntity> getAllAudioFiles() {
        return listeningTasksRepository.findAll();
    }

    @PostMapping
    public ListeningTasksEntity createAudioFile(@RequestBody ListeningTasksEntity audioFile) {
        return listeningTasksRepository.save(audioFile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListeningTasksEntity> updateAudioFile(@PathVariable Long id, @RequestBody ListeningTasksEntity audioFileDetails) {
        ListeningTasksEntity file = listeningTasksRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Audio file not found with id: " + id));

        file.setFilename(audioFileDetails.getFilename());
        file.setFileURL(audioFileDetails.getFileURL());
        file.setType(audioFileDetails.getType());

        ListeningTasksEntity updatedFile = listeningTasksRepository.save(file);
        return ResponseEntity.ok(updatedFile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAudioFile(@PathVariable Long id) {
        ListeningTasksEntity file = listeningTasksRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Audio file not found with id: " + id));

        listeningTasksRepository.delete(file);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}