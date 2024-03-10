package com.atul.account.v1.config.swagger

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info =
        Info(
            title = "Account Microservice",
            version = "V1",
            description = "A delicious API for account management in the food ordering application.",
        ),
)
class SpringDocConfig
