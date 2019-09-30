package com.kafka.kafkademo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Slf4j
@Component
public class AnotherProducer{
    @Value("${kafka.bootstrap.servers}")
    private String kafkaBootstrapServers;

    @Value("${zookeeper.groupId}")
    private String zookeeperGroupId;

    @Value("${zookeeper.host}")
    String zookeeperHost;

    @Value("${kafka.topic.springboot}")
    private String topicName;

//    @Bean
//    public void setupServer() {
//        Properties producerProperties = new Properties();
//        producerProperties.put("bootstrap.servers", kafkaBootstrapServers);
//        producerProperties.put("acks", "all");
//        producerProperties.put("retries", 0);
//        producerProperties.put("batch.size", 16384);
//        producerProperties.put("linger.ms", 1);
//        producerProperties.put("buffer.memory", 33554432);
//        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);
//
//
//        Properties consumerProperties = new Properties();
//        consumerProperties.put("bootstrap.servers", kafkaBootstrapServers);
//        consumerProperties.put("group.id", zookeeperGroupId);
//        consumerProperties.put("zookeeper.session.timeout.ms", "6000");
//        consumerProperties.put("zookeeper.sync.time.ms","2000");
//        consumerProperties.put("auto.commit.enable", "false");
//        consumerProperties.put("auto.commit.interval.ms", "1000");
//        consumerProperties.put("consumer.timeout.ms", "-1");
//        consumerProperties.put("max.poll.records", "1");
//        consumerProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        consumerProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//
//        Thread kafkaConsumerThread = new Thread(() -> {
//            log.info("Starting Kafka consumer thread.");
//
//            SimpleKafkaConsumer simpleKafkaConsumer = new SimpleKafkaConsumer(
//                    topicName,
//                    consumerProperties
//            );
//
//            simpleKafkaConsumer.runSingleWorker();
//        });
//
//        /*
//         * Starting the first thread.
//         */
//        kafkaConsumerThread.start();
//
//        sendTestMessagesToKafka(producer);
//    }
//
//    private void sendTestMessagesToKafka(KafkaProducer<String, String> producer) {
//        /*
//        Creating a loop which iterates 10 times, from 0 to 9, and sending a
//        simple message to Kafka.
//         */
//        for (int index = 0; index < 10; index++) {
//            sendKafkaMessage("The index is now: " + index, producer, topicName);
//        }
//
//        /*
//        Creating a loop which iterates 10 times, from 0 to 9, and creates an instance of JSONObject
//        in each iteration. We'll use this simple JSON object to illustrate how we can send a JSON
//        object as a message in Kafka.
//         */
//        for (int index = 0; index < 10; index++) {
//
//            /*
//            We'll create a JSON object which will have a bunch of fields, and another JSON object,
//            which will be nested inside the first JSON object. This is just to demonstrate how
//            complex objects could be serialized and sent to topics in Kafka.
//             */
//            JSONObject jsonObject = new JSONObject();
//            JSONObject nestedJsonObject = new JSONObject();
//
//            try {
//                /*
//                Adding some random data into the JSON object.
//                 */
//                jsonObject.put("index", index);
//                jsonObject.put("message", "The index is now: " + index);
//
//                /*
//                We're adding a field in the nested JSON object.
//                 */
//                nestedJsonObject.put("nestedObjectMessage", "This is a nested JSON object with index: " + index);
//
//                /*
//                Adding the nexted JSON object to the main JSON object.
//                 */
//                jsonObject.put("nestedJsonObject", nestedJsonObject);
//
//            } catch (JSONException e) {
//                log.error(e.getMessage());
//            }
//
//            /*
//            We'll now serialize the JSON object we created above, and send it to the same topic in Kafka,
//            using the same function we used earlier.
//            You can use any JSON library for this, just make sure it serializes your objects properly.
//            A popular alternative to the one I've used is Gson.
//             */
//            sendKafkaMessage(jsonObject.toString(), producer, topicName);
//        }
//    }
//
//    /**
//     * Function to send a message to Kafka
//     * @param payload The String message that we wish to send to the Kafka topic
//     * @param producer The KafkaProducer object
//     * @param topic The topic to which we want to send the message
//     */
//    private static void sendKafkaMessage(String payload,
//                                         KafkaProducer<String, String> producer,
//                                         String topic)
//    {
//        log.info("Sending Kafka message: " + payload);
//        producer.send(new ProducerRecord<>(topic, payload));
//    }
}
