package de.heikomaass.performance.core.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class Angebot {

    UUID angebotsId;

    ZahlungsInfo zahlungsInfo;
}
