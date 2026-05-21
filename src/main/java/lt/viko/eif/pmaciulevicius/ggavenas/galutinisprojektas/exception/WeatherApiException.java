package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.exception;

/**
 * Thrown when WeatherAPI returns an error or cannot be reached.
 */
public class WeatherApiException extends RuntimeException {

    public WeatherApiException(String message) {
        super(message);
    }

    public WeatherApiException(String message, Throwable cause) {
        super(message, cause);
    }
}