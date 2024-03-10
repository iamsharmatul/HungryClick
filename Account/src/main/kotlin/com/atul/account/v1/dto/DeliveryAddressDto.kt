package com.atul.account.v1.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty

/**
 * DTO for {@link com.atul.account.v1.entity.AddressEntity}
 */
@Schema(description = "Delivery Address Data Transfer Object")
@JsonIgnoreProperties(ignoreUnknown = true)
data class DeliveryAddressDto(
    @field:Schema(
        description = "The unique identifier of the address. This field is optional and is only present when the address is being updated.",
        required = false,
        example = "1",
    )
    val id: Long? = null,
    @field:Schema(
        description = "The house number of the address. This field is required and must not be empty.",
        required = true,
        example = "123",
    )
    @field:NotEmpty
    val houseNumber: String,
    @field:Schema(
        description = "The street name of the address. This field is required and must not be empty.",
        required = true,
        example = "Main St",
    )
    @field:NotEmpty
    val street: String,
    @field:Schema(
        description = "The city name of the address. This field is required and must not be empty.",
        required = true,
        example = "Mainz",
    )
    @field:NotEmpty
    val city: String,
    @field:Schema(
        description = "The state or province of the address. This field is required and must not be empty. For example, 'Rheinland-Pfalz' (Rhineland-Palatinate) for addresses in Germany.",
        required = true,
        example = "Rheinland-Pfalz",
    )
    @field:NotEmpty
    val state: String,
    @field:Schema(
        description = "The zip or postal code of the address. This field is required and must not be empty. For example, '53235' for addresses in Germany.",
        required = true,
        example = "53235",
    )
    @field:NotEmpty
    val zipCode: String,
    @field:Schema(
        description = "The country name of the address. This field is required and must not be empty. For example, 'Germany'.",
        required = true,
        example = "Germany",
    )
    @field:NotEmpty
    val country: String,
)
