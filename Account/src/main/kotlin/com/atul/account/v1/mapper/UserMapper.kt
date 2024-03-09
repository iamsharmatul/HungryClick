package com.atul.account.v1.mapper

import com.atul.account.v1.dto.UserDto
import com.atul.account.v1.entity.UserEntity

object UserMapper {
    fun toEntity(userDto: UserDto): UserEntity {
        return UserEntity(
            firstName = userDto.firstName,
            lastName = userDto.lastName,
            gender = userDto.gender,
            email = userDto.email,
            phone = userDto.phone,
        )
    }

    fun toDto(userEntity: UserEntity): UserDto {
        return UserDto(
            id = userEntity.id,
            firstName = userEntity.firstName,
            lastName = userEntity.lastName,
            email = userEntity.email,
            gender = userEntity.gender,
            phone = userEntity.phone,
        )
    }

    fun updateEntity(
        existingUserEntity: UserEntity,
        userDto: UserDto,
    ): UserEntity {
        existingUserEntity.firstName = userDto.firstName
        existingUserEntity.lastName = userDto.lastName
        existingUserEntity.gender = userDto.gender
        existingUserEntity.email = userDto.email
        existingUserEntity.phone = userDto.phone
        return existingUserEntity
    }
}
