package com.atul.account.v1.entity

import jakarta.persistence.*

private const val ACCOUNT_SCHEMA = "hc_account"
private const val USER_TABLE_NAME = "users"
private const val USER_SEQUENCE_NAME = "user_seq"

@Entity
@Table(schema = ACCOUNT_SCHEMA, name = USER_TABLE_NAME)
data class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
        @SequenceGenerator(name = "user_sequence_generator",
                schema = ACCOUNT_SCHEMA,
                sequenceName = USER_SEQUENCE_NAME,
                allocationSize = 1
        )
        @Column(name = "id", nullable = false)
        val id: Long? = null,

        @Column(name = "first_name", nullable = false)
        var firstName: String,

        @Column(name = "last_name", nullable = false)
        var lastName: String,

        @Column(name = "email", nullable = false)
        var email: String,

        @Column(name = "gender", nullable = false)
        var gender: String,

        @Column(name = "phone", nullable = false)
        var phone: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserEntity

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (email != other.email) return false
        if (gender != other.gender) return false
        if (phone != other.phone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + phone.hashCode()
        return result
    }

    override fun toString(): String {
        return "UserEntity(id=$id, firstName='$firstName', lastName='$lastName', email='$email', " +
                "gender='$gender', phone='$phone')"
    }
}