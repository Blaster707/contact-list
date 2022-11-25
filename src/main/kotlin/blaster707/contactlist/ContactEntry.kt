package blaster707.contactlist

data class ContactEntry (
    val person: Person,
    val addressList: List<Address> = emptyList(),
    val phoneNumberList: List<PhoneNumber> = emptyList()
    ){

    val firstName = person.firstName
    val lastName = person.lastName

}

