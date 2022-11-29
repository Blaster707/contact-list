package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class ContactList(val contacts: MutableList<ContactEntry>) {

    companion object ContactListFunctions {
        /*fun contactListIDSet(contactList: ContactList): Set<String>{
            var idSet: Set<String> = setOf()
            for (contactEntry in contactList.array) {
                idSet = idSet.plus(contactEntry.id)
            }
            return idSet
        }*/
    }
    fun contactListAll(): String{
        var output: String = ""
        for (contactEntry in contacts) {
            output = output.plus("ID: ${contactEntry.id} \n${contactEntry.lastName}, ${contactEntry.firstName}\n")
        }
        return output
    }

}