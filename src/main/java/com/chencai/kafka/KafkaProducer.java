package com.chencai.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.IOException;
import java.util.Properties;

public class KafkaProducer {

    private final org.apache.kafka.clients.producer.KafkaProducer<Integer, String> producer;

    public KafkaProducer(String topic) {
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaProperties.KAFKA_BROKER_LIST);
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("client.id", "producerDemo");

        this.producer = new org.apache.kafka.clients.producer.KafkaProducer<Integer, String>(props);
    }

    public void sendMeg() {
        producer.send(new ProducerRecord<Integer, String>(KafkaProperties.TOPIC, 1, "message"), new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                System.out.println("message send to : [ " + recordMetadata.partition() +" ], offset: [ " + recordMetadata.offset() + " ]");
            }
        });
    }

    public static void main(String[] args) throws IOException {
        KafkaProducer producer = new KafkaProducer(KafkaProperties.TOPIC);
        producer.sendMeg();
        System.in.read();
    }
}
