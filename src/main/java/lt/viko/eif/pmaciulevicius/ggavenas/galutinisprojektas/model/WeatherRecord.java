package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.model;

import java.time.LocalDate;

public class WeatherRecord {

    private Long id;
    private WeatherLocation location;
    private LocalDate date;
    private Double averageTemperature;
    private Double minimumTemperature;
    private Double maximumTemperature;
    private Double precipitation;
    private Double windSpeed;
    private Double pressure;

    public WeatherRecord() {
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Double getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(Double maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public Double getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(Double minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public WeatherLocation getLocation() {
        return location;
    }

    public void setLocation(WeatherLocation location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
