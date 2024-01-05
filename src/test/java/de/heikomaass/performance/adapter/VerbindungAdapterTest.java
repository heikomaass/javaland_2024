package de.heikomaass.performance.adapter;

import de.heikomaass.performance.adapter.externalmodel.Halt;
import de.heikomaass.performance.adapter.externalmodel.Verbindung;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class VerbindungAdapterTest {


    private VerbindungAdapter verbindungAdapter;

    @BeforeEach
    void before() {
        RestClient.Builder builder = RestClient.builder();

        MockRestServiceServer mockServer = MockRestServiceServer.bindTo(builder).build();
        mockServer.expect(requestTo("/api/verbindungen")).andRespond(withSuccess("""
                {
                  "results": [
                    {
                      "verbindungsId": "3c93ddaa-226e-4c5f-a03d-1f972f6ae0d3",
                      "verkehrsmittel": [
                        {
                          "produkt": "ICE 727",
                          "halte": [
                            {
                              "bahnhofsnummer": "8000105",
                              "abfahrt": "2024-05-12T18:53:00",
                              "anzeigeName": "Frankfurt(Main) Hbf"
                            }
                          ]
                        }
                      ]
                    }
                  ]
                }
                                
                """, MediaType.APPLICATION_JSON));

        verbindungAdapter = new VerbindungAdapter(builder.build());
    }

    @Test
    void shouldReturnVerbindung() {
        List<Verbindung> verbindungen = verbindungAdapter.getVerbindungen();

        assertThat(verbindungen.size()).isEqualTo(1);
        assertThat(verbindungen).anySatisfy(verbindung -> {
            assertThat(verbindung.getVerbindungsId()).isEqualTo(UUID.fromString("3c93ddaa-226e-4c5f-a03d-1f972f6ae0d3"));
            assertThat(verbindung.getVerkehrsmittel()).isNotEmpty();
            assertThat(verbindung.getVerkehrsmittel()).anySatisfy(verkehrsmittel -> {
                assertThat(verkehrsmittel.getProdukt()).isEqualTo("ICE 727");
                assertThat(verkehrsmittel.getHalte()).isNotEmpty();
                assertThat(verkehrsmittel.getHalte()).isEqualTo(List.of(Halt
                        .builder()
                        .bahnhofsnummer("8000105")
                        .anzeigeName("Frankfurt(Main) Hbf")
                        .abfahrt(LocalDateTime.parse("2024-05-12T18:53:00"))
                        .build()));
            });
        });

    }
}