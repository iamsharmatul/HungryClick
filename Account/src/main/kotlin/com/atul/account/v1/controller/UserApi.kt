package com.atul.account.v1.controller

import com.atul.account.v1.dto.DeliveryAddressDto
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
@RequestMapping("/v1/users") // Common base path for UserApi
interface UserApi {
    @Tag(name = "User API")
    @Operation(summary = "Get a user by its id")
    @GetMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserById(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", value = "id", required = true)
        id: Long,
    ): ResponseEntity<UserDto>

    @Tag(name = "User API")
    @Operation(summary = "Create a new user")
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createUser(
        @RequestBody
        user: UserDto,
        uriComponentsBuilder: UriComponentsBuilder,
    ): ResponseEntity<UserDto>

    @Tag(name = "User API")
    @Operation(summary = "Update a user by Id")
    @PutMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateUser(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", value = "id", required = true)
        id: Long,
        @RequestBody(required = true)
        user: UserDto,
    ): ResponseEntity<UserDto>

    @Tag(name = "User API")
    @Operation(summary = "Delete a user by Id")
    @DeleteMapping(path = ["/{id}"])
    fun deleteUser(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", value = "id", required = true)
        id: Long,
    ): ResponseEntity<Void>

    @Tag(name = "Delivery Address API")
    @Operation(summary = "Get all delivery addresses of a user by its id")
    @GetMapping(path = ["/{id}/delivery-addresses"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getDeliveryAddressesByUserId(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", required = true)
        id: Long,
    ): ResponseEntity<Set<DeliveryAddressDto>>

    @Tag(name = "Delivery Address API")
    @Operation(summary = "Add a new delivery address to a user by its id")
    @PostMapping(
        path = ["/{id}/delivery-addresses"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun addDeliveryAddressToUser(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", required = true)
        id: Long,
        @Valid
        @RequestBody(required = true)
        address: DeliveryAddressDto,
        uriComponentsBuilder: UriComponentsBuilder,
    ): ResponseEntity<DeliveryAddressDto>

    @Tag(name = "Delivery Address API")
    @Operation(summary = "Update a delivery address of a user by its id")
    @PutMapping(path = ["/{id}/delivery-addresses/{addressId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun modifyDeliveryAddressOfUser(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", required = true)
        id: Long,
        @Parameter(description = "The Unique Id of the delivery address", example = "1")
        @PathVariable(name = "addressId", value = "addressId", required = true)
        addressId: Long,
        @Valid
        @RequestBody(required = true)
        address: DeliveryAddressDto,
    ): ResponseEntity<DeliveryAddressDto>

    @Tag(name = "Delivery Address API")
    @Operation(summary = "Delete a delivery address of a user by its id")
    @DeleteMapping(path = ["/{id}/delivery-addresses/{addressId}"])
    fun removeDeliveryAddressOfUser(
        @Parameter(description = "The Unique Id of the user", example = "1")
        @PathVariable(name = "id", required = true)
        id: Long,
        @Parameter(description = "The Unique Id of the delivery address", example = "1")
        @PathVariable(name = "addressId", value = "addressId", required = true)
        addressId: Long,
    ): ResponseEntity<Void>
}
