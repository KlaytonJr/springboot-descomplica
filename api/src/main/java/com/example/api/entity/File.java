package com.example.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    private String fileName;
    private String linkDownload;
    private String fileExtension;
    private Long size;
}
