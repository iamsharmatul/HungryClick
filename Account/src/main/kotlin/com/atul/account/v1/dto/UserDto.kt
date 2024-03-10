package com.atul.account.v1.dto

import com.atul.account.v1.entity.Gender
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty

@Schema(description = "User Data Transfer Object")
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDto(
    @field:Schema(
        description = "The unique identifier of the user. This field is optional and is only present when the user is being updated.",
        required = false,
        example = "1",
    )
    val id: Long? = null,
    @field:Schema(
        description = "The first name of the user",
        required = true,
        example = "John",
    )
    @field:NotEmpty
    val firstName: String,
    @field:Schema(
        description = "The last name of the user",
        required = true,
        example = "Doe",
    )
    @field:NotEmpty
    val lastName: String,
    @field:Schema(
        description = "The email address of the user",
        required = true,
        example = "john.doe@example.com",
    )
    @field:NotEmpty
    val email: String,
    @field:Schema(
        description = "The gender of the user",
        required = true,
        example = "MALE",
    )
    @field:NotEmpty
    val gender: Gender,
    @field:Schema(
        description = "The phone number of the user",
        required = true,
        example = "1234567890",
    )
    @field:NotEmpty
    val phone: String,
)
