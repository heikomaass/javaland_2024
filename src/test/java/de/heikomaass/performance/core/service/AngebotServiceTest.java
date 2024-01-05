package de.heikomaass.performance.core.service;

import de.heikomaass.performance.core.model.Angebot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AngebotServiceTest {

    AngebotService angebotService;

    @BeforeEach
    void before() {
        angebotService = new AngebotService();
    }

    @Test
    void shouldReturnAngebote() {
        List<Angebot> angebote = angebotService.getAngebote();
        assertThat(angebote).isNotEmpty();

        assertThat(angebote).allSatisfy(angebot -> {
            assertThat(angebot.getAngebotsId()).isNotNull();
            assertThat(angebot.getZahlungsInfo()).isNotNull();
        });
    }

}