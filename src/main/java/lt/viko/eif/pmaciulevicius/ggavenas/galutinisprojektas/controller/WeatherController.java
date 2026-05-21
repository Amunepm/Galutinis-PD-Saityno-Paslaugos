package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto.WeatherResponse;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.model.WeatherSearch;
import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.service.WeatherService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * REST controller for weather endpoints.
 */
@RestController
@Tag(name = "Weather", description = "Endpoints for realtime weather data and search history")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Returns current weather by city name or coordinates.
     *
     * @param query city name, for example "Vilnius", or coordinates "54.6872,25.2797"
     * @return current weather information
     */
    @Operation(
            summary = "Get current weather",
            description = "Returns realtime weather information by city name or coordinates."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Weather information returned successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameter"),
            @ApiResponse(responseCode = "502", description = "WeatherAPI request failed")
    })
    @GetMapping("/api/weather/current")
    public EntityModel<WeatherResponse> getCurrentWeather(
            @Parameter(description = "City name or coordinates, for example Vilnius or 54.6872,25.2797")
            @RequestParam String query
    ) {
        WeatherResponse response = weatherService.getCurrentWeather(query);

        return EntityModel.of(
                response,
                linkTo(methodOn(WeatherController.class).getCurrentWeather(query)).withSelfRel(),
                linkTo(methodOn(WeatherController.class).getRecentSearches()).withRel("history")
        );
    }

    /**
     * Returns the last 10 successful weather searches.
     *
     * @return recent weather search history
     */
    @Operation(
            summary = "Get search history",
            description = "Returns the last 10 successful weather searches stored in the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search history returned successfully")
    })
    @GetMapping("/api/weather/history")
    public CollectionModel<WeatherSearch> getRecentSearches() {
        List<WeatherSearch> searches = weatherService.getRecentSearches();

        return CollectionModel.of(
                searches,
                linkTo(methodOn(WeatherController.class).getRecentSearches()).withSelfRel(),
                linkTo(methodOn(WeatherController.class).getCurrentWeather("Vilnius")).withRel("current-weather-example")
        );
    }
}
