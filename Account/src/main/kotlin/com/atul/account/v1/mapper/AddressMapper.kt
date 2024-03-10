package com.atul.account.v1.mapper

import com.atul.account.v1.dto.DeliveryAddressDto
import com.atul.account.v1.entity.DeliveryAddressEntity

object AddressMapper {
    fun toEntity(deliveryAddressDto: DeliveryAddressDto): DeliveryAddressEntity {
        return DeliveryAddressEntity(
            houseNumber = deliveryAddressDto.houseNumber,
            street = deliveryAddressDto.street,
            city = deliveryAddressDto.city,
            state = deliveryAddressDto.state,
            zipCode = deliveryAddressDto.zipCode,
            country = deliveryAddressDto.country,
        )
    }

    fun toAddressDtos(addressEntities: Set<DeliveryAddressEntity>): Set<DeliveryAddressDto> {
        return addressEntities.map { toDto(it) }.toSet()
    }

    fun toDto(deliveryAddressEntity: DeliveryAddressEntity): DeliveryAddressDto {
        return DeliveryAddressDto(
            id = deliveryAddressEntity.id,
            houseNumber = deliveryAddressEntity.houseNumber,
            street = deliveryAddressEntity.street,
            city = deliveryAddressEntity.city,
            state = deliveryAddressEntity.state,
            zipCode = deliveryAddressEntity.zipCode,
            country = deliveryAddressEntity.country,
        )
    }

    fun updateEntity(
        existingDeliveryAddressEntity: DeliveryAddressEntity,
        deliveryAddressDto: DeliveryAddressDto,
    ): DeliveryAddressEntity {
        existingDeliveryAddressEntity.houseNumber = deliveryAddressDto.houseNumber
        existingDeliveryAddressEntity.street = deliveryAddressDto.street
        existingDeliveryAddressEntity.city = deliveryAddressDto.city
        existingDeliveryAddressEntity.state = deliveryAddressDto.state
        existingDeliveryAddressEntity.zipCode = deliveryAddressDto.zipCode
        existingDeliveryAddressEntity.country = deliveryAddressDto.country
        return existingDeliveryAddressEntity
    }
}
