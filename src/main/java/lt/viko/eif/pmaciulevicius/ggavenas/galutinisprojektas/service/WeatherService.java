package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.service;

import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.client.WeatherApiClient;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto.CurrentWeatherDto;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto.LocationDto;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto.WeatherApiResponse;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto.WeatherResponse;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.exception.InvalidWeatherRequestException;
import org.springframework.stereotype.Service;

import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.model.WeatherSearch;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.repository.WeatherSearchRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Contains business logic for current weather requests.
 */
@Service
public class WeatherService {

    private final WeatherApiClient weatherApiClient;
    private final WeatherSearchRepository weatherSearchRepository;

    public WeatherService(WeatherApiClient weatherApiClient, WeatherSearchRepository weatherSearchRepository) {
        this.weatherApiClient = weatherApiClient;
        this.weatherSearchRepository = weatherSearchRepository;
    }

    /**
     * Returns current weather by city name or coordinates.
     *
     * @param query city name or coordinates
     * @return simplified weather response
     */
    public WeatherResponse getCurrentWeather(String query) {
        validateQuery(query);

        WeatherApiResponse apiResponse = weatherApiClient.getCurrentWeather(query);

        if (apiResponse == null || apiResponse.location() == null || apiResponse.current() == null) {
            throw new InvalidWeatherRequestException("Weather data was not found for: " + query);
        }

        WeatherResponse weatherResponse = mapToWeatherResponse(apiResponse);
        saveSearch(query, weatherResponse);
        return weatherResponse;
    }

    private void validateQuery(String query) {
        if (query == null || query.isBlank()) {
            throw new InvalidWeatherRequestException("Weather query cannot be empty");
        }

        if (query.length() > 100) {
            throw new InvalidWeatherRequestException("Weather query is too long");
        }
    }

    private WeatherResponse mapToWeatherResponse(WeatherApiResponse apiResponse) {
        LocationDto location = apiResponse.location();
        CurrentWeatherDto current = apiResponse.current();

        String condition = current.condition() != null
                ? current.condition().text()
                : "Unknown";

        return new WeatherResponse(
                location.name(),
                location.country(),
                location.lat(),
                location.lon(),
                location.localtime(),
                current.lastUpdated(),
                current.tempC(),
                current.feelsLikeC(),
                current.humidity(),
                current.windKph(),
                condition
        );
    }
    private void saveSearch(String query, WeatherResponse weatherResponse) {
        WeatherSearch weatherSearch = new WeatherSearch(
                query,
                weatherResponse.city(),
                weatherResponse.country(),
                weatherResponse.temperatureC(),
                weatherResponse.condition(),
                LocalDateTime.now()
        );

        weatherSearchRepository.save(weatherSearch);
    }
    public List<WeatherSearch> getRecentSearches() {
        return weatherSearchRepository.findTop10ByOrderBySearchedAtDesc();
    }
}