package de.heikomaass.performance.controller.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RecreatingObjectMapperFactoryTest {

    RecreatingObjectMapperFactory recreatingObjectMapperFactory = new RecreatingObjectMapperFactory();

    @Test
    void shouldRecreateObjectMapper() {
        ObjectMapper firstObjectMapper = recreatingObjectMapperFactory.getObjectMapper();
        ObjectMapper secondObjectMapper = recreatingObjectMapperFactory.getObjectMapper();

        assertThat(firstObjectMapper).isNotSameAs(secondObjectMapper);
    }

}