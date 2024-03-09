package com.atul.account.v1.exception.error

import java.time.OffsetDateTime

data class ErrorResponse(
        val errorCode: String,
        val message: String,
        val timestamp: OffsetDateTime = OffsetDateTime.now()
)
