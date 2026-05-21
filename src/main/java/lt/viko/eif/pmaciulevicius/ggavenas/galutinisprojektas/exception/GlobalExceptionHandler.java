package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.exception;

import lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Converts application exceptions into JSON HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidWeatherRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidWeatherRequest(InvalidWeatherRequestException exception) {
        return buildResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(WeatherApiException.class)
    public ResponseEntity<ErrorResponse> handleWeatherApiException(WeatherApiException exception) {
        return buildResponse(HttpStatus.BAD_GATEWAY, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception exception) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected server error");
    }

    private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String message) {
        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message
        );

        return ResponseEntity.status(status).body(response);
    }
}