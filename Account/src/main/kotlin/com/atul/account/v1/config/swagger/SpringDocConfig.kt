package com.atul.account.v1.config.swagger

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.annotations.info.Info

@Configuration
@OpenAPIDefinition(info = Info(
        title = "Account Microservice",
        version = "v1",
        description = "A delicious API for account management in the food ordering application."
))
class SpringDocConfig