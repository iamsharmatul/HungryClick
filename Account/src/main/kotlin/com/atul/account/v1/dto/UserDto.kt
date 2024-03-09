package com.atul.account.v1.dto

import com.atul.account.v1.entity.Gender
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "User Data Transfer Object")
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDto(
    @field:Schema(description = "The unique identifier of the user", example = "1")
    val id: Long? = null,
    @field:Schema(description = "The first name of the user", example = "John")
    val firstName: String,
    @field:Schema(description = "The last name of the user", example = "Doe")
    val lastName: String,
    @field:Schema(description = "The email address of the user", example = "john.doe@example.com")
    val email: String,
    @field:Schema(description = "The gender of the user", example = "MALE")
    val gender: Gender,
    @field:Schema(description = "The phone number of the user", example = "1234567890")
    val phone: String,
)
