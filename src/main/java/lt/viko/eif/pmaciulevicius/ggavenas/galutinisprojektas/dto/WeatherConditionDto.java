package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherConditionDto(
        String text,
        String icon,
        Integer code
) {
}