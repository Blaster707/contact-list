package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class PhoneNumber (
    val number: String,
    val label: LocationLabel
)