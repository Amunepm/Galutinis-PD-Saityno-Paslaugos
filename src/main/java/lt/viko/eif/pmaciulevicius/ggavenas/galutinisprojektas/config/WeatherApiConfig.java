package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Configures the HTTP client used to call WeatherAPI through RapidAPI.
 */
@Configuration
public class WeatherApiConfig {

    @Bean
    public RestClient weatherApiRestClient(
            @Value("${weatherapi.base-url}") String baseUrl,
            @Value("${weatherapi.host}") String host,
            @Value("${weatherapi.key}") String apiKey
    ) {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("X-RapidAPI-Host", host)
                .defaultHeader("X-RapidAPI-Key", apiKey)
                .build();
    }
}