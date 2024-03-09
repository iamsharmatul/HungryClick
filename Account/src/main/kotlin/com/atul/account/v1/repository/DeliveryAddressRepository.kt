package com.atul.account.v1.repository

import com.atul.account.v1.entity.DeliveryAddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeliveryAddressRepository : JpaRepository<DeliveryAddressEntity, Long>
