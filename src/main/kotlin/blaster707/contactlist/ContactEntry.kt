package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class  ContactEntry (
    val id: String,
    val person: Person,
    val addressList: List<Address> = emptyList(),
    val phoneNumberList: List<PhoneNumber> = emptyList()
    ){

    val firstName = person.name.firstName
    val lastName = person.name.lastName
    val age = person.age

    fun toSummary(): ContactSummary {
        return ContactSummary(id, person.name)
    }

}

@Serializable
data class ContactDetail (
    val person: Person,
    val addressList: List<Address> = emptyList(),
    val phoneNumberList: List<PhoneNumber> = emptyList()
        )

