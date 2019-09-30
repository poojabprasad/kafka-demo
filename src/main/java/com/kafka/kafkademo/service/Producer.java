package com.kafka.kafkademo.service;

import com.kafka.kafkademo.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
public class Producer {
    @Autowired
    private KafkaTemplate<String, ?> kafkaTemplate;

    public void sendMessage(String topic, User user) {
        log.info("===sending the message {} for topic {}====", user, topic);
        //this.kafkaTemplate.send(topic, user.toString());
        this.kafkaTemplate.send(MessageBuilder.withPayload(user.toString()).setHeader(KafkaHeaders.TOPIC, topic).build());
    }
}
