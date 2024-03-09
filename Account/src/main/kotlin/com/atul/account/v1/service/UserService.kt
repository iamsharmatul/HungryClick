package com.atul.account.v1.service

import com.atul.account.v1.dto.UserDto
import com.atul.account.v1.exception.UserNotFoundException
import com.atul.account.v1.mapper.UserConverter
import com.atul.account.v1.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun getUserById(id: Long): UserDto {
        return userRepository.findById(id).orElse(null)
                ?.let { UserConverter.toDto(it) }
                ?: throw UserNotFoundException("User not found with id: $id.")
    }

    fun createUser(userDto: UserDto): UserDto {
        val userEntity = UserConverter.toEntity(userDto)
        val savedUserEntity = userRepository.save(userEntity)
        return UserConverter.toDto(savedUserEntity)
    }

    fun updateUser(id: Long, userDto: UserDto): UserDto {
        val existingUserEntity = userRepository.findById(id)
                .orElseThrow { UserNotFoundException("User not found with id: $id.") }

        val updatedUserEntity = UserConverter.updateEntity(existingUserEntity, userDto)
        val savedUserEntity = userRepository.save(updatedUserEntity)
        return UserConverter.toDto(savedUserEntity)
    }

    fun deleteUser(id: Long) {
        getUserById(id)
        userRepository.deleteById(id)
    }
}
