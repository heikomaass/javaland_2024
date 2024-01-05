package de.heikomaass.performance.adapter.externalmodel;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Verkehrsmittel {
    String produkt;
    List<Halt> halte;
}
