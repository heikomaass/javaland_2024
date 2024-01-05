package de.heikomaass.performance.controller.mapper;

import de.heikomaass.performance.controller.dto.AngebotDto;
import de.heikomaass.performance.core.model.Angebot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = ZahlungsInfoMapper.class,
        componentModel = "spring")
public interface AngebotMapper {
    @Mapping(source = "zahlungsInfo", target = "zahlungsInfoDto")
    AngebotDto toAngebotDto(Angebot angebot);

    List<AngebotDto> toAngebotDtoList(List<Angebot> angebotList);
}
