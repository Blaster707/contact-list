package blaster707.contactlist

object ContactListBuilders {

    fun contactEntryBuilder(): ContactEntry {

        val contactID = idBuilder()
        val contactPerson = personBuilder()
        val addressList = listOf(addressBuilder())
        val phoneNumberList = listOf(phoneNumberBuilder())

        return ContactEntry(contactID, contactPerson, addressList, phoneNumberList)

    }

    fun idBuilder(): String {
        println("Please type in an ID Number.")
        val idInput = readln()
        if (idInput in ContactList.contactListIDSet(TODO())) {
            
        }
    }

    fun personBuilder(): Person{
        println("What is the first name of the person?")
        val firstNameInput: String? = readlnOrNull()
        println("What is the last name of the person?")
        val lastNameInput: String? = readlnOrNull()
        if (firstNameInput == null || lastNameInput == null) {throw Exception("Invalid entry; first name and last name are required.  Cancelling addition of this person.")}
        println("Would you like to add a middle name for this person?  If so, type it here.  Otherwise, press enter.")
        val middleNameInput: String? = readlnOrNull()
        println("What is the age of this person?  If you would like to leave this field blank, press enter. Entering anything other than numbers will result in this field being left blank.")
        val ageInput = readlnOrNull()
        val ageResult = when {
            ageInput.isNullOrBlank() -> null
            ageInput.all { char -> char.isDigit() } -> ageInput.toInt()
            else -> null
        }

        val fullNameInput = Name(firstNameInput, lastNameInput, middleNameInput)
        return Person(fullNameInput, ageResult)

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