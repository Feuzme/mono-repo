package fr.feuzme.demo.monorepo.home;

import fr.feuzme.demo.monorepo.configuration.ConditionalOnComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ConditionalOnComponent("home-component")
public class HomeListener {

    @EventListener(ApplicationReadyEvent.class)
    void listenHomeEvent() {

    }
}
