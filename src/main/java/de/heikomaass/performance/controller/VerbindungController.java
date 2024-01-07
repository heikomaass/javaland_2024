package de.heikomaass.performance.controller;

import de.heikomaass.performance.adapter.VerbindungAdapter;
import de.heikomaass.performance.adapter.externalmodel.Verbindung;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VerbindungController {
    private final VerbindungAdapter verbindungAdapter;

    @GetMapping("/verbindungen")
    public List<Verbindung> getVerbindungen() {
        return verbindungAdapter.getVerbindungen();
    }
}
