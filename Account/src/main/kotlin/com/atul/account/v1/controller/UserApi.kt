package com.atul.account.v1.controller

import com.atul.account.v1.dto.UserDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

/** REST API for managing users. */
@Tag(name = "User API", description = "Operations for managing users")
@RequestMapping("/v1/users") // Common base path for UserApi
interface UserApi {
    @Operation(summary = "Get a user by its id")
    @GetMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserById(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", value = "id", required = true)
        id: Long,
    ): ResponseEntity<UserDto>

    @Operation(summary = "Create a new user")
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createUser(
        @RequestBody
        user: UserDto,
        uriComponentsBuilder: UriComponentsBuilder,
    ): ResponseEntity<UserDto>

    @Operation(summary = "Update a user by Id")
    @PutMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateUser(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", value = "id", required = true)
        id: Long,
        @Valid
        @RequestBody(required = true)
        user: UserDto,
    ): ResponseEntity<UserDto>

    @Operation(summary = "Delete a user by Id")
    @DeleteMapping(path = ["/{id}"])
    fun deleteUser(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", value = "id", required = true)
        id: Long,
    ): ResponseEntity<Void>
}
