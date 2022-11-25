package blaster707.contactlist

object Builder {

    fun contactEntryBuilder(): ContactEntry {

        val contactPerson = PersonBuilder().getPersonInput()
        val addressList = listOf(addressBuilder())
        val phoneNumberList = listOf(phoneNumberBuilder())

        return ContactEntry(contactPerson, addressList, phoneNumberList)

    }

    fun phoneNumberBuilder(): PhoneNumber {
        println("Please type in the phone number you would like to add.")
        val phoneNumberInput = readln()
        println("Please set a label for this phone number.")
        val phoneNumberLocationLabelInput = locationLabelBuilder()

        return PhoneNumber(phoneNumberInput, phoneNumberLocationLabelInput)
    }

    fun addressBuilder(): Address {
        println("You will now add an address for this contact entry.")
        println("Please set a label for this address.")
        val addressLocationLabelInput = locationLabelBuilder()
        println("What is the house number for this address?")
        val addressNumberInput = readln()
        println("What is the street name for this address?")
        val addressStreetNameInput = readln()
        println("What is the city for this address?")
        val addressCityInput = readln()
        println("What is the state for this address?")
        val addressStateInput = readln()
        println("What is the zipcode for this address?")
        val addressZipCodeInput = readln()

        return Address(
            addressNumberInput,
            addressStreetNameInput,
            addressCityInput,
            addressStateInput,
            addressZipCodeInput,
            addressLocationLabelInput
        )
    }

    fun locationLabelBuilder(): LocationLabel {
        println(" 1: Home \n 2: Mobile \n 3: Work \n 4: Other")
        print("Label Number: ")
        return when (readln()) {
            "1" -> LocationLabel.Home
            "2" -> LocationLabel.Mobile
            "3" -> LocationLabel.Work
            "4" -> LocationLabel.Other
            else -> {
                println("Invalid entry. Setting to \"Other\" by default.")
                LocationLabel.Other
            }
        }
    }
}

object StringBuilder {

    fun labelString(locationLabel: LocationLabel): String { return "$locationLabel" }

    fun addressString(addressZ: Address): String {
        return ("${labelString(addressZ.label)} \n${addressZ.addressNumber} ${addressZ.streetName} \n${addressZ.city}, ${addressZ.state} ${addressZ.zipCode}\n")
    }

}