package de.heikomaass.performance.objectmapper.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {
    @Bean
    AngebotService angebotsService() {
        return new AngebotService();
    }

}
