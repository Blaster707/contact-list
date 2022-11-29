package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class ContactSummary (
    val id: String,
    val name: PersonName
)