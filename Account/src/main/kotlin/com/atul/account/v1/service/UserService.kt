package com.atul.account.v1.service

import com.atul.account.v1.dto.DeliveryAddressDto
import com.atul.account.v1.dto.UserDto
import com.atul.account.v1.exception.DeliveryAddressNotFoundException
import com.atul.account.v1.exception.UserNotFoundException
import com.atul.account.v1.mapper.AddressMapper
import com.atul.account.v1.mapper.UserMapper
import com.atul.account.v1.repository.DeliveryAddressRepository
import com.atul.account.v1.repository.UserRepository
import org.hibernate.Hibernate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * The UserService is responsible for handling the business logic related to users and delivery addresses.
 * It provides methods to get, create, update, and delete users and delivery addresses, and it uses the UserRepository
 * and AddressRepository to interact with the database.
 */
@Service
class UserService(
    private val userRepository: UserRepository,
    private val deliveryAddressRepository: DeliveryAddressRepository,
) {
    fun getUserById(id: Long): UserDto {
        return userRepository.findById(id).orElse(null)
            ?.let { UserMapper.toDto(it) }
            ?: throw UserNotFoundException("User not found with id: $id.")
    }

    fun createUser(userDto: UserDto): UserDto {
        val userEntity = UserMapper.toEntity(userDto)
        val savedUserEntity = userRepository.save(userEntity)
        return UserMapper.toDto(savedUserEntity)
    }

    fun updateUser(
        id: Long,
        userDto: UserDto,
    ): UserDto {
        val existingUserEntity =
            userRepository.findById(id).orElseThrow { UserNotFoundException("User not found with id: $id.") }

        val updatedUserEntity = UserMapper.updateEntity(existingUserEntity, userDto)
        val savedUserEntity = userRepository.save(updatedUserEntity)
        return UserMapper.toDto(savedUserEntity)
    }

    fun deleteUser(id: Long) {
        getUserById(id)
        userRepository.deleteById(id)
    }

    @Transactional
    fun getDeliveryAddressesByUserId(userId: Long): Set<DeliveryAddressDto> {
        val user =
            userRepository.findById(userId).orElseThrow { UserNotFoundException("User not found with id: $userId") }

        // Force initialization before the transaction closes
        Hibernate.initialize(user.addresses)
        return AddressMapper.toAddressDtos(user.addresses)
    }

    @Transactional
    fun addDeliveryAddressToUser(
        userId: Long,
        deliveryAddressDto: DeliveryAddressDto,
    ): DeliveryAddressDto {
        val user =
            userRepository.findById(userId).orElseThrow { UserNotFoundException("User not found with id: $userId") }
        val deliveryAddressEntity = AddressMapper.toEntity(deliveryAddressDto)
        user.addAddress(deliveryAddressEntity)

        return deliveryAddressRepository.save(deliveryAddressEntity) // Save for cascading with User
            .let { AddressMapper.toDto(it) }
    }

    @Transactional
    fun modifyDeliveryAddressOfUser(
        id: Long,
        addressId: Long,
        newDeliveryAddress: DeliveryAddressDto,
    ): DeliveryAddressDto? {
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        val deliveryAddressToUpdate =
            user.addresses.find { it.id == addressId }
                ?: throw DeliveryAddressNotFoundException(
                    "Delivery Address not found with Id: $addressId or does not " +
                        "belong to the user with userId: $id",
                )

        val updatedDeliveryAddress = AddressMapper.updateEntity(deliveryAddressToUpdate, newDeliveryAddress)
        return deliveryAddressRepository.save(updatedDeliveryAddress)
            .let { AddressMapper.toDto(it) }
    }

    @Transactional
    fun removeDeliveryAddressOfUser(
        id: Long,
        addressId: Long,
    ) {
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        val deliveryAddress =
            deliveryAddressRepository.findById(addressId)
                .orElseThrow { DeliveryAddressNotFoundException("Delivery Address with not found with Id: $addressId") }

        user.removeAddress(deliveryAddress)
        deliveryAddressRepository.delete(deliveryAddress)
    }
}
