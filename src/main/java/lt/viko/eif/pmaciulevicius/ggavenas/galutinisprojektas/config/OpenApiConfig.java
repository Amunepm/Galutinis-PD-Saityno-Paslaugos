package lt.viko.eif.pmaciulevicius.ggavenas.galutinisprojektas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI documentation configuration.
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Weather REST API",
                version = "1.0",
                description = "REST API for getting realtime weather data and storing search history.",
                contact = @Contact(
                        name = "Weather project team"
                )
        )
)
public class OpenApiConfig {
}