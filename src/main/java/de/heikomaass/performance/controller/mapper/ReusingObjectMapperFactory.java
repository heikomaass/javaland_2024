package de.heikomaass.performance.controller.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReusingObjectMapperFactory implements ObjectMapperFactory {

    static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
