package de.heikomaass.performance.controller.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface ObjectMapperFactory {
    ObjectMapper getObjectMapper();
}
