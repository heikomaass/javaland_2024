package de.heikomaass.performance.core;

import de.heikomaass.performance.core.service.AngebotService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {
    @Bean
    AngebotService angebotsService() {
        return new AngebotService();
    }

}
