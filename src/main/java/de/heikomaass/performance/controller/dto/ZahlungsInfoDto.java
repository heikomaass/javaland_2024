package de.heikomaass.performance.controller.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Builder
@Value
public class ZahlungsInfoDto {
    List<String> zulaessigeZahlungsmittel;
}
