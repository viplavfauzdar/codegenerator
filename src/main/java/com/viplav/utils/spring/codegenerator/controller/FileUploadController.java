package com.viplav.utils.spring.codegenerator.controller;

import java.io.IOException;
import java.io.File;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@RestController
public class FileUploadController {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String uploadDir = "/Users/viplavfauzdar/tmp";//System.getProperty("java.io.tmpdir");
        String filePath = uploadDir + File.separator + file.getOriginalFilename();

        try {
            file.transferTo(new File(filePath));
            return "File uploaded successfully to temporary folder: " + filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file.";
        }
    }
}
