package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherApiResponse(
        LocationDto location,
        CurrentWeatherDto current
) {
}