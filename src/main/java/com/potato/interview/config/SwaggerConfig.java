package com.potato.interview.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI cardsAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cards API")
                        .description("""
                                This is a dummy API for creation / retrieval of cards data.
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Kamil P")
                                .email("kpotoczny1493@gmail.com"))
                );
    }

    @Bean
    public GroupedOpenApi v1Api() {
        return GroupedOpenApi.builder()
                .group("@v1")
                .pathsToMatch("/v1/**")
                .build();
    }

    @Bean
    public GroupedOpenApi manageApi() {
        return GroupedOpenApi.builder()
                .group("manage")
                .pathsToMatch("/manage/**")
                .build();
    }
}
