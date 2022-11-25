package blaster707.contactlist

data class Person (
    val personName: Name,
    val age: Int?
    )

data class Name (
    val firstName: String,
    val lastName: String,
    val middleName: String?
        )