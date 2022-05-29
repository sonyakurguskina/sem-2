package ru.itis.kurguskina.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentationConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("Public API")
                .pathsToMatch("/**")
                .build();
    }

    private OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("11-004 RESTful API")
                        .description("API with samples for 11-004"));
    }
}