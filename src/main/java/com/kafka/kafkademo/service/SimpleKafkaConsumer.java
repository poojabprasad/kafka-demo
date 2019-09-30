package com.kafka.kafkademo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class SimpleKafkaConsumer {
    private KafkaConsumer<String, String> kafkaConsumer;

//    public SimpleKafkaConsumer(String topicName, Properties consumerProperties) {
//
//        kafkaConsumer = new KafkaConsumer<>(consumerProperties);
//        kafkaConsumer.subscribe(Arrays.asList(topicName));
//    }

//    public void runSingleWorker() {
//
//        /*
//         * We will start an infinite while loop, inside which we'll be listening to
//         * new messages in each topic that we've subscribed to.
//         */
//        while(true) {
//
//            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
//
//            for (ConsumerRecord<String, String> record : records) {
//
//                /*
//                Whenever there's a new message in the Kafka topic, we'll get the message in this loop, as
//                the record object.
//                 */
//
//                /*
//                Getting the message as a string from the record object.
//                 */
//                String message = record.value();
//
//                /*
//                Logging the received message to the console.
//                 */
//                log.info("Received message: " + message);
//
//                /*
//                If you remember, we sent 10 messages to this topic as plain strings.
//                10 other messages were serialized JSON objects. Now we'll deserialize them here.
//                But since we can't make out which message is a serialized JSON object and which isn't,
//                we'll try to deserialize all of them.
//                So, obviously, we'll get an exception for the first 10 messages we receive.
//                We'll just log the errors and not worry about them.
//                 */
//                try {
//                    JSONObject receivedJsonObject = new JSONObject(message);
//
//                    /*
//                    To make sure we successfully deserialized the message to a JSON object, we'll
//                    log the index of JSON object.
//                     */
//                    log.info("Index of deserialized JSON object: " + receivedJsonObject.getInt("index"));
//                } catch (JSONException e) {
//                    log.error(e.getMessage());
//                }
//
//                /*
//                Once we finish processing a Kafka message, we have to commit the offset so that
//                we don't end up consuming the same message endlessly. By default, the consumer object takes
//                care of this. But to demonstrate how it can be done, we have turned this default behaviour off,
//                instead, we're going to manually commit the offsets.
//                The code for this is below. It's pretty much self explanatory.
//                 */
//                {
//                    Map<TopicPartition, OffsetAndMetadata> commitMessage = new HashMap<>();
//
//                    commitMessage.put(new TopicPartition(record.topic(), record.partition()),
//                            new OffsetAndMetadata(record.offset() + 1));
//
//                    kafkaConsumer.commitSync(commitMessage);
//
//                    log.info("Offset committed to Kafka.");
//                }
//            }
//        }
//    }
}
