package dev.luanfernandes.pizzaria.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static dev.luanfernandes.pizzaria.constants.OpenApiConfigConstants.OPENAPI_CONTACT_EMAIL;
import static dev.luanfernandes.pizzaria.constants.OpenApiConfigConstants.OPENAPI_CONTACT_NAME;
import static dev.luanfernandes.pizzaria.constants.OpenApiConfigConstants.OPENAPI_CONTACT_URL;
import static dev.luanfernandes.pizzaria.constants.OpenApiConfigConstants.OPENAPI_EXTERNAL_DOCS_DESCRIPTION;
import static dev.luanfernandes.pizzaria.constants.OpenApiConfigConstants.OPENAPI_EXTERNAL_DOCS_URL;
import static dev.luanfernandes.pizzaria.constants.OpenApiConfigConstants.OPENAPI_INFO_DESCRIPTION;
import static dev.luanfernandes.pizzaria.constants.OpenApiConfigConstants.OPENAPI_INFO_TITLE;
import static dev.luanfernandes.pizzaria.constants.OpenApiConfigConstants.OPENAPI_INFO_VERSION;
import static java.util.stream.Stream.of;

@OpenAPIDefinition(
        info =
        @Info(
                title = OPENAPI_INFO_TITLE,
                version = OPENAPI_INFO_VERSION,
                description = OPENAPI_INFO_DESCRIPTION,
                contact =
                @Contact(
                        name = OPENAPI_CONTACT_NAME,
                        email = OPENAPI_CONTACT_EMAIL,
                        url = OPENAPI_CONTACT_URL)),
        externalDocs =
        @ExternalDocumentation(
                description = OPENAPI_EXTERNAL_DOCS_DESCRIPTION,
                url = OPENAPI_EXTERNAL_DOCS_URL))
@Configuration
public class OpenApiConfig {

    @Value(value = "${openapi-servers-urls}")
    private String[] openApiServersUrls;

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI();
        of(openApiServersUrls).forEach(url -> openApi.addServersItem(new Server().url(url)));
        return openApi;
    }
}
