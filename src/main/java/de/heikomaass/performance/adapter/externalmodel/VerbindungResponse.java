package de.heikomaass.performance.adapter.externalmodel;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
public class VerbindungResponse {
    List<Verbindung> results;
}
