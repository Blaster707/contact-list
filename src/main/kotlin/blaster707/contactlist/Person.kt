package blaster707.contactlist

data class Person (val firstName: String, val lastName: String)

class PersonBuilder{
    fun getPersonInput(): Person{
        println("What is the first name of the person?")
        val firstNameInput: String? = readLine()
        println("What is the last name of the person?")
        val lastNameInput: String? = readLine()
        if (firstNameInput == null || lastNameInput == null) {throw Exception("Invalid entry; first name and last name are required.  Cancelling addition of this person.")}
        else return Person(firstNameInput, lastNameInput)
    }
}