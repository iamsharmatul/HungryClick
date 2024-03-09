package com.atul.account.v1.exception.error

object ErrorCodeConstants {
    // Authentication and Authorization Errors
    const val AUTHENTICATION_FAILE = "A001"
    const val INVALID_TOKEN = "A002"
    const val INSUFFICIENT_PERMISSIONS = "A003"

    // Validation Errors
    const val MISSING_REQUIRED_FIELD = "V001"
    const val INVALID_FORMAT = "V002"
    const val VALUE_OUT_OF_RANGE = "V003"
    const val BAD_REQUEST = "V004"

    // Resource Management Errors
    const val RESOURCE_NOT_FOUND = "R001"
    const val UNABLE_TO_CREATE_RESOURCE = "R002"
    const val UNABLE_TO_UPDATE_RESOURCE = "R003"
    const val UNABLE_TO_DELETE_RESOURCE = "R004"

    // Data Integrity Errors
    const val DATA_INTEGRITY_VIOLATION = "D001"
    const val DUPLICATE_KEY_VIOLATION = "D002"
    const val REFERENTIAL_INTEGRITY_VIOLATION = "D003"

    // Service Availability Errors
    const val SERVICE_UNAVAILABLE = "S001"
    const val SERVICE_TIMEOUT = "S002"
    const val EXTERNAL_SERVICE_ERROR = "S003"

    // General Errors
    const val UNEXPECTED_ERROR = "G001"
    const val UNSUPPORTED_OPERATION = "G002"
    const val METHOD_NOT_ALLOWED = "G003"
}
