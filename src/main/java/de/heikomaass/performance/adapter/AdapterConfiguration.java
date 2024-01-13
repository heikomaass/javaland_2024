package de.heikomaass.performance.adapter;


import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.ConnectionKeepAliveStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.TimeValue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Slf4j
public class AdapterConfiguration {

    @Bean(name = "verbindungRestClient")
    @ConditionalOnProperty(value = "persistent_connections", havingValue = "false")
    RestClient verbindungRestClient(@Value("${verbindung.baseurl}") String verbindungBaseUrl) {
        log.atInfo().log("Using JdkClientHttpRequestFactory");

        return RestClient.builder()
                .requestFactory(new JdkClientHttpRequestFactory()) // Default when Apache Commons Http is not on classpath
                .baseUrl(verbindungBaseUrl)
                .build();
    }

    @Bean(name = "verbindungRestClient")
    @ConditionalOnProperty(value = "persistent_connections", havingValue = "true")
    RestClient verbindungRestClientPooling(@Value("${verbindung.baseurl}") String verbindungBaseUrl,
                                           CloseableHttpClient closeableHttpClient) {
        log.atInfo().log("Using HttpComponentsClientHttpRequestFactory");

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(closeableHttpClient);

        return RestClient.builder()
                .requestFactory(factory) // Default when Apache Commons Http is not on classpath
                .baseUrl(verbindungBaseUrl)
                .build();
    }

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(50);
        connectionManager.setDefaultMaxPerRoute(50);
        return connectionManager;
    }

    @Bean
    public CloseableHttpClient httpClient(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager) {
        return HttpClients.custom()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setKeepAliveStrategy((response, context) -> TimeValue.ofSeconds(50))
                .build();
    }


    @Bean
    public VerbindungAdapter verbindungAdapter(@Qualifier(value = "verbindungRestClient") RestClient restClient) {
        return new VerbindungAdapter(restClient);
    }
}
