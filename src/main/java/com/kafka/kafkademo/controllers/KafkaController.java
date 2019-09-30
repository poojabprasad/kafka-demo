package com.kafka.kafkademo.controllers;

import com.kafka.kafkademo.models.User;
import com.kafka.kafkademo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kafka.kafkademo.config.constants.TOPIC1;
import static com.kafka.kafkademo.config.constants.TOPIC2;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/username/{message}")
    public void publishMessage(@PathVariable("message") String message) {
        User user = User.builder()
                .firstName(message)
                .lastName(message)
                .age(32)
                .build();
        this.producer.sendMessage(TOPIC1, user);
    }

    @GetMapping("/bookname/{message}")
    public void publishAnotherMessage(@PathVariable("message") String message) {
        User user = User.builder()
                .firstName(message)
                .lastName(message)
                .age(32)
                .build();
        this.producer.sendMessage(TOPIC2, user);
    }
}
