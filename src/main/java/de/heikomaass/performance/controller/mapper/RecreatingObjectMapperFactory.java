package de.heikomaass.performance.controller.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RecreatingObjectMapperFactory implements ObjectMapperFactory {
    @Override
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
