package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class Address (
    val addressNumber: String?,
    val streetName: String?,
    val city: String?,
    val state: String?,
    val zipCode: String,
    val label: LocationLabel = LocationLabel.Other
){

    companion object AddressFunctions {

        fun addressStringAll(addressList: List<Address>): String {
            var result = ""
            for (addressX in addressList) result = result.plus(addressString(addressX))
            return result
        }

        fun addressString(addressZ: Address): String {
            return ("${LocationLabel.labelString(addressZ.label)} \n${addressZ.addressNumber} ${addressZ.streetName} \n${addressZ.city}, ${addressZ.state} ${addressZ.zipCode}\n")
        }
    }

}