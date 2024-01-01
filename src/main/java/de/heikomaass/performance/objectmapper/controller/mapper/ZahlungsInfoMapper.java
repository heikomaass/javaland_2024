package de.heikomaass.performance.objectmapper.controller.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import de.heikomaass.performance.objectmapper.controller.dto.ZahlungsInfoDto;
import de.heikomaass.performance.objectmapper.core.ZahlungsInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ZahlungsInfoMapper {
    ObjectMapper objectMapper = new ObjectMapper();


    default ZahlungsInfoDto toDto(ZahlungsInfo zahlungsInfo) {
        return objectMapper.convertValue(zahlungsInfo, ZahlungsInfoDto.class);
    }
}
