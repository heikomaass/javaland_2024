package de.heikomaass.performance.objectmapper.controller;

import de.heikomaass.performance.objectmapper.controller.mapper.AngebotMapper;
import de.heikomaass.performance.objectmapper.core.AngebotService;
import de.heikomaass.performance.objectmapper.core.CoreConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(CoreConfiguration.class)
@Configuration
@ComponentScan(value = "de.heikomaass.performance.objectmapper.controller.mapper")
public class ControllerConfiguration {

    @Bean
    ZahlungsInfoController zahlungsInfoController(AngebotService zahlungsInfoService, AngebotMapper angebotMapper) {
        return new ZahlungsInfoController(zahlungsInfoService, angebotMapper);
    }

}