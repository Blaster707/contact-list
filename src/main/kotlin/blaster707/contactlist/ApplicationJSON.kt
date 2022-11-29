package blaster707.contactlist

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Path

object ApplicationJSON {

    fun applicationJSON() {

        if (!Files.exists(Path.of("C:\\Projects\\contacts.json"))) {
            Files.createFile(Path.of("C:\\Projects\\contacts.json"))
        }

        val savedJsonContactList = Files.readString(Path.of("C:\\Projects\\contacts.json"))

        val savedContactList = Json.decodeFromString<ContactList>(savedJsonContactList)

        for (contactEntry in savedContactList.array) {
            println(contactEntry.firstName)
            println(contactEntry.lastName)
            println(contactEntry.age)
        }
    }

}