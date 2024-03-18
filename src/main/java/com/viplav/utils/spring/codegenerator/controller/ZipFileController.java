/*package com.viplav.utils.spring.codegenerator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viplav.utils.spring.codegenerator.utils.ZipFileCreator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class ZipFileController {

    @PostMapping("/createZip", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> createZipFile(@RequestBody String[] filesToZip) {
        ZipFileCreator zipFileCreator = new ZipFileCreator();
        zipFileCreator.createZipFile("myZipFile.zip", filesToZip);
        return ResponseEntity.ok().body("Zip file created successfully".getBytes());
    }
    
}*/
