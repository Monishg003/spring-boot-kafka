package com.example.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileProcess {
    private String id;
    private String fileName;
    private String filePath;

}
