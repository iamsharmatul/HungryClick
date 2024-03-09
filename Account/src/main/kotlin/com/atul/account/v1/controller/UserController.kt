package com.atul.account.v1.controller

import com.atul.account.v1.dto.UserDto
import com.atul.account.v1.exception.BadRequestException
import com.atul.account.v1.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
class UserController(
        private val userService: UserService
) : UserApi {

    companion object {
        val log = LoggerFactory.getLogger(UserController::class.java)
    }

    override fun getUserById(id: Long): ResponseEntity<UserDto> {
        val user = userService.getUserById(id)
        return ResponseEntity.ok(user).also { log.debug("") }
    }

    override fun createUser(user: UserDto, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<UserDto> {
        val createdUser = userService.createUser(user)
        val newResourceId = createdUser.id

        val locationUri = uriComponentsBuilder.path("/v1/users/{id}").buildAndExpand(newResourceId).toUri()

        return ResponseEntity.created(locationUri).body(createdUser)
    }

    override fun updateUser(id: Long, user: UserDto): ResponseEntity<UserDto> {
        if (user.id != id) {
            throw BadRequestException("Path Variable id doesn't match with Id provided in the request body.")
        }
        val updatedUser = userService.updateUser(id, user)
        return ResponseEntity.ok(updatedUser)
    }

    override fun deleteUser(id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

}