package com.atul.account.v1.entity

import jakarta.persistence.*

private const val ACCOUNT_SCHEMA = "hc_account"
private const val ADDRESS_TABLE_NAME = "delivery_addresses"
private const val ADDRESS_SEQUENCE_NAME = "delivery_address_seq"

@Entity
@Table(schema = ACCOUNT_SCHEMA, name = ADDRESS_TABLE_NAME)
class DeliveryAddressEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_address_sequence_generator")
    @SequenceGenerator(
        name = "delivery_address_sequence_generator",
        schema = ACCOUNT_SCHEMA,
        sequenceName = ADDRESS_SEQUENCE_NAME,
        allocationSize = 1,
    )
    @Column(name = "id", nullable = false)
    var id: Long? = null,
    @Column(name = "house_number", nullable = false)
    var houseNumber: String,
    @Column(name = "street", nullable = false)
    var street: String,
    @Column(name = "city", nullable = false)
    var city: String,
    @Column(name = "state", nullable = false)
    var state: String,
    @Column(name = "zip_code", nullable = false)
    var zipCode: String,
    @Column(name = "country", nullable = false)
    var country: String,
//    @ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY)
//    var users: MutableSet<UserEntity> = mutableSetOf(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DeliveryAddressEntity

        if (id != other.id) return false
        if (houseNumber != other.houseNumber) return false
        if (street != other.street) return false
        if (city != other.city) return false
        if (state != other.state) return false
        if (zipCode != other.zipCode) return false
        if (country != other.country) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + houseNumber.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + state.hashCode()
        result = 31 * result + zipCode.hashCode()
        result = 31 * result + country.hashCode()
        return result
    }

    override fun toString(): String {
        return "AddressEntity(id=$id, houseNumber='$houseNumber', street='$street', city='$city', state='$state', " +
            "zipCode='$zipCode', country='$country')"
    }
}
