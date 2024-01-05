package de.heikomaass.performance.adapter.externalmodel;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Builder
@Value
public class Verbindung {
    UUID verbindungsId;
    List<Verkehrsmittel> verkehrsmittel;
}
