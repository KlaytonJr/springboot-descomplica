package com.example.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class FileStorageProperties {

    @Value("${file.uploadDir}")
    private String uploadDir;

}
