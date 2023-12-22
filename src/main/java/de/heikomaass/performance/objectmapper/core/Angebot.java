package de.heikomaass.performance.objectmapper.core;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class Angebot {

    UUID angebotsId;

    ZahlungsInfo zahlungsInfo;
}
