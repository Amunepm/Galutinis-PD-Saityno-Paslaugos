package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto;

public record WeatherResponse(
        String city,
        String country,
        double latitude,
        double longitude,
        String localTime,
        String lastUpdated,
        double temperatureC,
        double feelsLikeC,
        int humidity,
        double windKph,
        String condition
) {
}