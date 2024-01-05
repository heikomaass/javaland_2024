package de.heikomaass.performance.controller;

import de.heikomaass.performance.controller.mapper.AngebotMapper;
import de.heikomaass.performance.core.service.AngebotService;
import de.heikomaass.performance.core.CoreConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(CoreConfiguration.class)
@Configuration
@ComponentScan(value = "de.heikomaass.performance.controller.mapper")
public class ControllerConfiguration {

    @Bean
    AngebotController zahlungsInfoController(AngebotService zahlungsInfoService, AngebotMapper angebotMapper) {
        return new AngebotController(zahlungsInfoService, angebotMapper);
    }

}