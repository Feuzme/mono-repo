package fr.feuzme.demo.monorepo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Profile("test")
@ActiveProfiles("test")
class MonoRepoDemoApplicationTests {
    @Test
    void contextLoads() {
    }
}
