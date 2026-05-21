package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LocationDto(
        String name,
        String region,
        String country,
        Double lat,
        Double lon,
        String localtime
) {
}