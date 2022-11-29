package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class  ContactEntry (
    val id: String,
    val person: Person,
    val addressList: List<Address> = emptyList(),
    val phoneNumberList: List<PhoneNumber> = emptyList()
    ){

    val firstName = person.personName.firstName
    val lastName = person.personName.lastName
    val age = person.age

    companion object ContactEntryFunctions {

        fun addressStringAll(addressList: List<Address>): String {
            var result = ""
            for (addressX in addressList) result = result.plus(Address.addressString(addressX))
            return result
        }
    }
}

