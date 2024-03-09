package com.atul.account.v1.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "User Data Transfer Object")
data class UserDto(
        @field:Schema(description = "The unique identifier of the user")
        val id: Long? = null,

        @field:Schema(description = "The first name of the user")
        val firstName: String,

        @field:Schema(description = "The last name of the user")
        val lastName: String,

        @field:Schema(description = "The email address of the user")
        val email: String,

        @field:Schema(description = "The gender of the user")
        val gender: String,

        @field:Schema(description = "The phone number of the user")
        val phone: String
)
