package de.heikomaass.performance.adapter.externalmodel;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class Halt {
    String bahnhofsnummer;
    String anzeigeName;
    LocalDateTime abfahrt;
    LocalDateTime ankunft;
}
