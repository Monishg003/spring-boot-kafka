package com.example.kafka.service;

import com.example.kafka.entity.FileProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final KafkaTemplate<String, FileProcess> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, FileProcess> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendFileCreated(FileProcess event) {

        kafkaTemplate.send("file-events", event.getId(), event);
    }


    @KafkaListener(topics = "file-events")
    public void consume(FileProcess event) {
        System.out.println("File received : " + event.getId() + " - " + event.getFileName());
    }

    @KafkaListener(topics = "file-events", groupId = "fdfe")
    public void consume3(FileProcess event) {
        System.out.println("File received: " + event.getId() + " - " + event.getFileName());
    }
}
