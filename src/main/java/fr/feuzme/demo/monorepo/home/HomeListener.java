package fr.feuzme.demo.monorepo.home;

import fr.feuzme.demo.monorepo.configuration.ConditionalOnComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ConditionalOnComponent("home-listener")
public class HomeListener {
    private final HomeService homeService;

    public HomeListener(HomeService homeService) {
        this.homeService = homeService;
    }

    @KafkaListener(topics = "home-topic")
    public void listenHome(HomeDto message) {
        homeService.saveHome(message);
        log.info("Saved : {}", message);
    }
}
