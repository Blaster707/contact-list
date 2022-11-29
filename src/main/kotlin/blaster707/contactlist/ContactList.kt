package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class ContactList(val array: Array<ContactEntry>)