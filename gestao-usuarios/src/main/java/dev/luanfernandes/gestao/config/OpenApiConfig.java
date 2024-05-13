package dev.luanfernandes.gestao.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.List.of;

@OpenAPIDefinition(
        info = @Info(
                title = "User Admin API",
                version = "0.0.1",
                description = "API for user administration",
                contact = @Contact(
                        name = "Luan Fernandes",
                        email = "contact@Luanfernandes.dev",
                        url = "https://luanfernandes.dev"
                )

        ),
        externalDocs = @ExternalDocumentation(
                description = "GitHub repository",
                url = "https://github.com/souluanf/user-admin")
)
@Configuration
public class OpenApiConfig {

    @Value("${openapi-servers-urls}")
    private String[] openApiServersUrls;


    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI();
        of(openApiServersUrls).forEach(url -> openApi.addServersItem(new Server().url(url)));
        return openApi;
    }
}
