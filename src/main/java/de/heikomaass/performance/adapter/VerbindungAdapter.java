package de.heikomaass.performance.adapter;

import de.heikomaass.performance.adapter.externalmodel.Verbindung;
import de.heikomaass.performance.adapter.externalmodel.VerbindungResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class VerbindungAdapter {

    private final RestClient restClient;

    public List<Verbindung> getVerbindungen() {

        VerbindungResponse verbindungResponse = restClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/verbindungen").build())
                .retrieve()
                .onStatus(HttpStatusCode::is2xxSuccessful, (request, response) -> {
                    log.atInfo().log("Successfull response" + request.getURI());
                })
                .body(VerbindungResponse.class);

        log.atInfo().log("Invoked verbindung: " + verbindungResponse);
        if (verbindungResponse != null) {
            return verbindungResponse.getResults();
        } else {
            // normally some kind of error handling would happen here.
            return List.of();
        }
    }
}
