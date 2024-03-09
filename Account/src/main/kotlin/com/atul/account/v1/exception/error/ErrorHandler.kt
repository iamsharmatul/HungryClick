package com.atul.account.v1.exception.error

import com.atul.account.v1.exception.BadRequestException
import com.atul.account.v1.exception.UserNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandler {
    companion object {
        private val log = LoggerFactory.getLogger(ErrorHandler::class.java)
    }

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException(exception: UserNotFoundException): ResponseEntity<ErrorResponse> {
        val message = "Resource not found - ${exception.message}"
        log.error(message, exception)
        return buildErrorResponse(HttpStatus.NOT_FOUND, ErrorCodeConstants.RESOURCE_NOT_FOUND, message)
    }

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequestException(exception: BadRequestException): ResponseEntity<ErrorResponse> {
        val message = "Bad request - ${exception.message}"
        log.error(message, exception)
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ErrorCodeConstants.BAD_REQUEST, message)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val message = "Internal server error - ${e.message}"
        log.error(message, e)
        return buildErrorResponse(status, ErrorCodeConstants.UNEXPECTED_ERROR, message)
    }

    private fun buildErrorResponse(
        status: HttpStatus,
        errorCode: String,
        message: String,
    ): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(errorCode, message)
        return ResponseEntity(errorResponse, status)
    }
}
