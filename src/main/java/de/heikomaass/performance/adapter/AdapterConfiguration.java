package de.heikomaass.performance.adapter;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

public class AdapterConfiguration {

    @Bean(name = "verbindungRestClient")
    RestClient verbindungRestClient(@Value("${verbindung.baseurl}") String verbindungBaseUrl) {
        return RestClient.builder()
                .baseUrl(verbindungBaseUrl)
                .build();
    }

    @Bean
    public VerbindungAdapter verbindungAdapter(@Qualifier(value = "verbindungRestClient") RestClient restClient) {
        return new VerbindungAdapter(restClient);
    }
}
