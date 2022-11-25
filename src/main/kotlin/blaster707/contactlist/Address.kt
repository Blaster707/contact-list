package blaster707.contactlist

data class Address (
    val addressNumber: String?,
    val streetName: String?,
    val city: String?,
    val state: String?,
    val zipCode: String,
    val label: LocationLabel = LocationLabel.Other
){

    fun addressStringAll(addressList: List<Address>): String {
        var result = ""
        for (addressX in addressList) result = result.plus(StringBuilder.addressString(addressX))
        return result
    }

}