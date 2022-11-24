package blaster707.contactlist

object Application {

    @JvmStatic
    fun main(args: Array<String>){
        val contactEntryX = contactEntryBuilder()

        println("${contactEntryX.person.firstName}, ${contactEntryX.person.lastName}")
        for (phoneNumber in contactEntryX.phoneNumberList) {
            println(phoneNumber.phoneNumberLabelString())
            println("${phoneNumber.number}\n")
        }
        //println(contactEntryX.addressStringAll(contactEntryX.addressList))
    }
}