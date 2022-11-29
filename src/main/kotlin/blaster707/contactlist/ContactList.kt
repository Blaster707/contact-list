package blaster707.contactlist

import kotlinx.serialization.Serializable

@Serializable
data class ContactList(val array: Array<ContactEntry>) {

    companion object ContactListFunctions {
        fun contactListIDSet(contactList: ContactList): Set<String>{
            var idSet: Set<String> = setOf()
            for (contactEntry in contactList.array) {
                idSet = idSet.plus(contactEntry.id)
            }
            return idSet
        }
    }

}