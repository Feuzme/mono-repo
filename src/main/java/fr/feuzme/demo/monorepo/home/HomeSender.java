package fr.feuzme.demo.monorepo.home;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class HomeSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    CompletableFuture<SendResult<String, String>> sendHome(Home home) {
        return kafkaTemplate.send(new ProducerRecord<>("home-topic", home.toString()));
    }

}
