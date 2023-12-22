package de.heikomaass.performance.objectmapper.core;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class ZahlungsInfo {

    List<String> zulaessigeZahlungsmittel;

}
