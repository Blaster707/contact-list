package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class Person (
    val name: PersonName,
    val age: Int?
    )

@Serializable
data class PersonName (
    val firstName: String,
    val lastName: String,
    val middleName: String?
        )