package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.client;

import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto.WeatherApiResponse;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.exception.WeatherApiException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

/**
 * Client responsible for communication with WeatherAPI through RapidAPI.
 */
@Component
public class WeatherApiClient {

    private final RestClient restClient;
    private final String apiKey;

    public WeatherApiClient(
            @Qualifier("weatherApiRestClient") RestClient restClient,
            @Value("${weatherapi.key}") String apiKey
    ) {
        this.restClient = restClient;
        this.apiKey = apiKey;
    }

    /**
     * Gets current weather by city name or coordinates.
     *
     * @param query city name or coordinates, for example "Vilnius" or "54.6872,25.2797"
     * @return raw WeatherAPI response
     */
    public WeatherApiResponse getCurrentWeather(String query) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new WeatherApiException("RapidAPI key is missing. Set RAPIDAPI_KEY environment variable.");
        }

        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/current.json")
                            .queryParam("q", query)
                            .build())
                    .retrieve()
                    .body(WeatherApiResponse.class);
        } catch (RestClientResponseException exception) {
            throw new WeatherApiException(
                    "WeatherAPI returned error " + exception.getStatusCode()
                            + ": " + exception.getResponseBodyAsString(),
                    exception
            );
        } catch (RestClientException exception) {
            throw new WeatherApiException("Failed to get current weather from WeatherAPI", exception);
        }
    }
}