package com.example.study.kafka;

import kafka.producer.KeyedMessage;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Kafka生产者
 */
public class KafkaProducerDemo extends Thread{

    private String topic;

    private Producer<Integer, String> producer;

    public KafkaProducerDemo(String topic) {
        this.topic = topic;
        Map<String,Object> configMap  = new HashMap<>();
        configMap.put("bootstrap.servers", "47.98.135.123:9092");
        configMap.put("metadata.broker.list",KafkaProperties.BROKER_LIST);
        configMap.put("serializer.class","kafka.serializer.StringEncoder");
        configMap.put("request.required.acks","1");
        configMap.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        configMap.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<Integer, String>(configMap);
    }
    @Override
    public void run() {
        int messageNo = 1;
        while(true) {
            String message = "message_" + messageNo;
            ProducerRecord<Integer, String> record = new ProducerRecord<Integer, String>("dpg",123,"GUN");
            producer.send(record);
            System.out.println("Sent: " + message);

            messageNo ++ ;

            try{
                Thread.sleep(2000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
