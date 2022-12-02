package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class ContactList(val contacts: MutableList<ContactEntry>) {

    fun contactListAll(): String{
        var output: String = ""
        for (contactEntry in contacts) {
            output = output.plus("ID: ${contactEntry.id} \n${contactEntry.lastName}, ${contactEntry.firstName}\n")
        }
        return output
    }

}