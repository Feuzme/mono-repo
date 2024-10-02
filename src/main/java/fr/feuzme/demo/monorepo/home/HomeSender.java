package fr.feuzme.demo.monorepo.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class HomeSender {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    void sendHome(Home home) {
        kafkaTemplate.send("home-topic", home);
    }
}
