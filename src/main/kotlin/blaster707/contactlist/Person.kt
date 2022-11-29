package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class Person (
    val personName: Name,
    val age: Int?
    )

@Serializable
data class Name (
    val firstName: String,
    val lastName: String,
    val middleName: String?
        )