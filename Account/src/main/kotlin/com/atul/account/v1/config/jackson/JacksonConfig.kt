package com.atul.account.v1.config.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.text.SimpleDateFormat

@Configuration
class JacksonConfig {

    @Bean
    @Primary // Important for overriding other potential ObjectMappers
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
                .registerModule(JavaTimeModule())  // Support for Java 8 Date/Time API
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false) // Standard date formats
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS) // Prevent failures when serializing empty beans
    }
}