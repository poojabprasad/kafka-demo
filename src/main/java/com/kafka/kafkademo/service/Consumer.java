package com.kafka.kafkademo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.kafka.kafkademo.config.constants.TOPIC1;
import static com.kafka.kafkademo.config.constants.TOPIC2;

@Slf4j
public class Consumer {
    @KafkaListener(topics = TOPIC1)
    public void receiveMessage(String message) throws IOException {
        log.info("Topic is {} : Received message {} =====", TOPIC1, message);
    }

    @KafkaListener(topics = TOPIC2)
    public void receiveNewMessage(String message) {
        log.info("Topic is {} : Received message {} ===", TOPIC2, message);
    }
}
