package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

/**
 * Represents one successful weather search stored in the database.
 */
@Entity
public class WeatherSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String query;
    private String city;
    private String country;
    private Double temperatureC;
    private String condition;
    private LocalDateTime searchedAt;

    public WeatherSearch() {
    }

    public WeatherSearch(String query, String city, String country, Double temperatureC, String condition, LocalDateTime searchedAt) {
        this.query = query;
        this.city = city;
        this.country = country;
        this.temperatureC = temperatureC;
        this.condition = condition;
        this.searchedAt = searchedAt;
    }

    public Long getId() {
        return id;
    }

    public String getQuery() {
        return query;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Double getTemperatureC() {
        return temperatureC;
    }

    public String getCondition() {
        return condition;
    }

    public LocalDateTime getSearchedAt() {
        return searchedAt;
    }
}