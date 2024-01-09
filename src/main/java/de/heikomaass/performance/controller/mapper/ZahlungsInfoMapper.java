package de.heikomaass.performance.controller.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import de.heikomaass.performance.controller.dto.ZahlungsInfoDto;
import de.heikomaass.performance.core.model.ZahlungsInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public abstract class ZahlungsInfoMapper {

    @Autowired
    ObjectMapperFactory objectMapperFactory;

    public ZahlungsInfoDto toDto(ZahlungsInfo zahlungsInfo) {
        return objectMapperFactory.getObjectMapper().convertValue(zahlungsInfo, ZahlungsInfoDto.class);
    }
}
