package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class ContactList(val array: Array<ContactEntry>) {

    companion object ContactListFunctions {
        /*fun contactListIDSet(contactList: ContactList): Set<String>{
            var idSet: Set<String> = setOf()
            for (contactEntry in contactList.array) {
                idSet = idSet.plus(contactEntry.id)
            }
            return idSet
        }*/

        fun contactListAll(contactList: ContactList): String{
            var output: String = ""
            for (contactEntry in contactList.array) {
                output = output.plus("ID: ${contactEntry.id} \n${contactEntry.lastName}, ${contactEntry.firstName}\n")
            }
            return output
        }
    }

}