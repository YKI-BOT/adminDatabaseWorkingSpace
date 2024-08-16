package com.tgbot.admin.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private AmazonS3 amazonS3;

    private final String bucketName = "bottg";

    @PostMapping("/upload/{type}")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String type) throws IOException {
        String folder = "";
        switch (type) {
            case "dialog":
                folder = "dialog/";
                break;
            case "multipleChoice":
                folder = "multipleChoice/";
                break;
            case "openEnded":
                folder = "openEnded/";
                break;
            case "trueFalse":
                folder = "trueFalse/";
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid type");
        }

        String fileName = folder + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file.getInputStream(), new ObjectMetadata()));

        String fileUrl = amazonS3.getUrl(bucketName, fileName).toString();
        return ResponseEntity.ok(fileUrl);
    }
}
