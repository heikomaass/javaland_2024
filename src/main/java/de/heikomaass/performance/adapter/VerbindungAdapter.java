package de.heikomaass.performance.adapter;

import de.heikomaass.performance.adapter.externalmodel.Verbindung;
import de.heikomaass.performance.adapter.externalmodel.VerbindungResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public class VerbindungAdapter {

    private final RestClient restClient;

    List<Verbindung> getVerbindungen() {
        VerbindungResponse verbindungResponse = restClient.get()
                .uri(URI.create("/api/verbindungen"))
                .retrieve().
                body(VerbindungResponse.class);
        if (verbindungResponse != null) {
            return verbindungResponse.getResults();
        } else {
            // normally some kind of error handling would happen here.
            return List.of();
        }
    }
}
