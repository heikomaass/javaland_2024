package de.heikomaass.performance.objectmapper.controller.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class AngebotDto {

    ZahlungsInfoDto zahlungsInfoDto;

}
