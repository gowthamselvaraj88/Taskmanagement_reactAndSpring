package com.TaskManagement.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    private static final String upload = "uploads";

    public void uploadFile(MultipartFile file) throws IOException {

        file.transferTo(new File("D:\\New folder" + file.getOriginalFilename()));
//        Path uploadPath = Path.of(upload);
//
//        if (!Files.exists(uploadPath)){
//            Files.createDirectories(uploadPath);
//        }
//
//        Path filePath = uploadPath.resolve(file.getOriginalFilename());
//
//        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
    }
}
