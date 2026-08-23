package com.example.kafka.controller;

import com.example.kafka.entity.FileProcess;
import com.example.kafka.service.KafkaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/file-process")
public class KafkaController {

    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping
    public String createPatient() {

        FileProcess event = new FileProcess(UUID.randomUUID().toString(), "File-01", "/home/downlods");

        kafkaService.sendFileCreated(event);

        return "File Process event sent";
    }
}
