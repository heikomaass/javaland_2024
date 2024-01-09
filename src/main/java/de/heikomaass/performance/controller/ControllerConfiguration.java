package de.heikomaass.performance.controller;

import de.heikomaass.performance.adapter.AdapterConfiguration;
import de.heikomaass.performance.adapter.VerbindungAdapter;
import de.heikomaass.performance.controller.mapper.AngebotMapper;
import de.heikomaass.performance.controller.mapper.ObjectMapperFactory;
import de.heikomaass.performance.controller.mapper.RecreatingObjectMapperFactory;
import de.heikomaass.performance.controller.mapper.ReusingObjectMapperFactory;
import de.heikomaass.performance.core.CoreConfiguration;
import de.heikomaass.performance.core.service.AngebotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({CoreConfiguration.class, AdapterConfiguration.class})
@Configuration
@ComponentScan(value = "de.heikomaass.performance.controller.mapper")
@Slf4j
public class ControllerConfiguration {

    @Bean
    AngebotController zahlungsInfoController(AngebotService zahlungsInfoService, AngebotMapper angebotMapper) {
        return new AngebotController(zahlungsInfoService, angebotMapper);
    }

    @Bean
    VerbindungController verbindungController(VerbindungAdapter verbindungAdapter) {
        return new VerbindungController(verbindungAdapter);
    }

    @Bean
    @ConditionalOnProperty(name = "objectmapperfactory", havingValue = "recreating")
    ObjectMapperFactory recreatingObjectMapperFactory() {
        log.atInfo().log("Using RecreatingObjectMapperFactory");
        return new RecreatingObjectMapperFactory();
    }

    @Bean
    @ConditionalOnProperty(name = "objectmapperfactory", havingValue = "reusing")
    ObjectMapperFactory reusingObjectMapperFactory() {
        log.atInfo().log("Using ReusingObjectMapperFactory");
        return new ReusingObjectMapperFactory();
    }

}