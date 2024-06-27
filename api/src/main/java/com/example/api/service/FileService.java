package com.example.api.service;

import org.springframework.stereotype.Service;

import com.example.api.config.FileStorageProperties;

@Service
public class FileService {

    public FileService(FileStorageProperties fileStorageProperties) {
        fileStorageProperties.getUploadDir();
    }
}
