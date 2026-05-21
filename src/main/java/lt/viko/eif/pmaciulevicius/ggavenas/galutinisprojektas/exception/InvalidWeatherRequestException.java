package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.exception;

/**
 * Thrown when the user sends invalid weather request parameters.
 */
public class InvalidWeatherRequestException extends RuntimeException {

    public InvalidWeatherRequestException(String message) {
        super(message);
    }
}