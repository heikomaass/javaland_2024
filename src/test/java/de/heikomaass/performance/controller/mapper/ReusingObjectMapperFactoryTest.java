package de.heikomaass.performance.controller.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReusingObjectMapperFactoryTest {

    private ReusingObjectMapperFactory reusingObjectMapperFactory;

    @BeforeEach
    void setup() {
        reusingObjectMapperFactory = new ReusingObjectMapperFactory();
    }

    @Test
    void shouldReuseObjectMapper() {
        ObjectMapper firstObjectMapper = reusingObjectMapperFactory.getObjectMapper();
        ObjectMapper secondObjectMapper = reusingObjectMapperFactory.getObjectMapper();
        assertThat(firstObjectMapper).isSameAs(secondObjectMapper);
    }
}