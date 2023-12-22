package de.heikomaass.performance.objectmapper.core;

import java.util.List;
import java.util.UUID;

public class AngebotService {

    public List<Angebot> getAngebote() {
        return List.of(randomAngebot(), randomAngebot(), randomAngebot(), randomAngebot());
    }

    private Angebot randomAngebot() {
        return Angebot.builder()
                .angebotsId(UUID.randomUUID())
                .zahlungsInfo(randomZahlungInfo())
                .build();
    }

    private ZahlungsInfo randomZahlungInfo() {
        return ZahlungsInfo.builder()
                .zulaessigeZahlungsmittel(List
                        .of(
                                randomZahlungsmittel(),
                                randomZahlungsmittel(),
                                randomZahlungsmittel()
                        ))
                .build();
    }

    private String randomZahlungsmittel() {
        return "ZAHLUNGSMITTEL_" + UUID.randomUUID();
    }
}
