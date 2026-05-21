package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrentWeatherDto(
        @JsonProperty("last_updated") String lastUpdated,
        @JsonProperty("temp_c") Double tempC,
        @JsonProperty("feelslike_c") Double feelsLikeC,
        @JsonProperty("wind_kph") Double windKph,
        @JsonProperty("pressure_mb") Double pressureMb,
        @JsonProperty("precip_mm") Double precipMm,
        Integer humidity,
        Integer cloud,
        Double uv,
        WeatherConditionDto condition
) {
}