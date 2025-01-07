package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.serviceinterface.FileSystemStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping("/webworks/media")
@CrossOrigin

public class MediaController {

    private  final FileSystemStorageService fileSystemStorageService;
    private final HttpServletRequest request;
    @Autowired
    public MediaController(FileSystemStorageService fileSystemStorageService, HttpServletRequest request) {
        this.fileSystemStorageService = fileSystemStorageService;
        this.request = request;
    }

    @PostMapping("/user/addFile")
    public Map<String,String> addFile(@RequestParam("file") MultipartFile file){
        String path = fileSystemStorageService.store(file);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url= ServletUriComponentsBuilder.fromHttpUrl(host).path("/webworks/media/").path(path).toUriString();
        return Map.of("url",url);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename ) throws IOException {
        Resource file =fileSystemStorageService.loadResource(filename);
        String contentType=Files.probeContentType(file.getFile().toPath());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(file);
    }
}
