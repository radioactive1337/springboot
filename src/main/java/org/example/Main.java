package org.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "TODO API",
                version = "1.0",
                description = "This is a sample API"
        )
)
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

//  http://localhost:8080/swagger-ui.html
//  http://localhost:8080/api-docs