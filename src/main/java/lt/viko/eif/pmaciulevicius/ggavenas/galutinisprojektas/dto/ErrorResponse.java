package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.dto;

import java.time.LocalDateTime;

/**
 * Represents an error response returned by the REST API.
 */
public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message
) {
}