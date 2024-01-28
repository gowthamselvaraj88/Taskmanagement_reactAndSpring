package com.TaskManagement.controller;


import com.TaskManagement.service.FileUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
@CrossOrigin(value = "*")
public class FileUploadController {

    private final FileUploadService fileUpload;

    public FileUploadController(FileUploadService fileUpload) {
        this.fileUpload = fileUpload;
    }

    @PostMapping("/uploadfile")
    public ResponseEntity<String> handleUpload(@RequestParam("file") MultipartFile file) throws IOException {

        //fileUpload.uploadFile(file);
        try{
            fileUpload.uploadFile(file);
            return ResponseEntity.ok("File Uploaded"  );
        }catch (IOException e){
            return ResponseEntity.status(500).body("Error!");
        }


    }
}
