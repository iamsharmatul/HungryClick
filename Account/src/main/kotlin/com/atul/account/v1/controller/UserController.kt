package com.atul.account.v1.controller

import com.atul.account.v1.dto.DeliveryAddressDto
import com.atul.account.v1.dto.UserDto
import com.atul.account.v1.exception.BadRequestException
import com.atul.account.v1.service.UserService
import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
class UserController(
    private val userService: UserService,
) : UserApi {
    companion object {
        private val log = LoggerFactory.getLogger(UserController::class.java)
    }

    override fun getUserById(id: Long): ResponseEntity<UserDto> {
        val user = userService.getUserById(id)
        return ResponseEntity.ok(user).also { log.debug("") }
    }

    override fun createUser(
        user: UserDto,
        uriComponentsBuilder: UriComponentsBuilder,
    ): ResponseEntity<UserDto> {
        val createdUser = userService.createUser(user)
        val newResourceId = createdUser.id

        val locationUri = uriComponentsBuilder.path("/v1/users/{id}").buildAndExpand(newResourceId).toUri()

        return ResponseEntity.created(locationUri).body(createdUser)
    }

    override fun updateUser(
        id: Long,
        user: UserDto,
    ): ResponseEntity<UserDto> {
        if (user.id != id) {
            throw BadRequestException("User path variable id doesn't match with Id provided in the request body.")
        }
        val updatedUser = userService.updateUser(id, user)
        return ResponseEntity.ok(updatedUser)
    }

    override fun deleteUser(id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

    override fun getDeliveryAddressesByUserId(id: Long): ResponseEntity<Set<DeliveryAddressDto>> {
        val deliveryAddresses = userService.getDeliveryAddressesByUserId(id)
        return ResponseEntity.ok(deliveryAddresses).also { log.debug("") }
    }

    @Transactional
    override fun addDeliveryAddressToUser(
        id: Long,
        address: DeliveryAddressDto,
        uriComponentsBuilder: UriComponentsBuilder,
    ): ResponseEntity<DeliveryAddressDto> {
        val createdDeliveryAddress = userService.addDeliveryAddressToUser(id, address)
        val newResourceId = createdDeliveryAddress.id

        val locationUri =
            uriComponentsBuilder.path(
                "/v1/users/{id}/delivery-addresses/{addressId}",
            ).buildAndExpand(id, newResourceId).toUri()

        return ResponseEntity.created(locationUri).body(createdDeliveryAddress)
    }

    override fun modifyDeliveryAddressOfUser(
        id: Long,
        addressId: Long,
        address: DeliveryAddressDto,
    ): ResponseEntity<DeliveryAddressDto> {
        if (address.id != addressId) {
            throw BadRequestException("Delivery-Address path variable id doesn't match with Id provided in the request body.")
        }
        val updatedDeliveryAddress = userService.modifyDeliveryAddressOfUser(id, addressId, address)
        return ResponseEntity.ok(updatedDeliveryAddress)
    }

    override fun removeDeliveryAddressOfUser(
        id: Long,
        addressId: Long,
    ): ResponseEntity<Void> {
        userService.removeDeliveryAddressOfUser(id, addressId)
        return ResponseEntity.noContent().build()
    }
}
