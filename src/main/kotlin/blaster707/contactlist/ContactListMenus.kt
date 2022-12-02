package blaster707.contactlist

class ContactListMenus {

    class ContactListMainMenu {
        fun contactListStart() {
            println("Welcome to the main menu!  Please select an option:")
            println(" 1: Search for Contact\n 2: Add Contact\n 3: Exit")
            val userInput = readln()
            if (userInput != "1" && userInput != "2" && userInput != "3") {
                println("Invalid entry. Would you like to try again?")
                print("Y/N: ")
                when (readln()) {
                    "Y", "y" -> contactListStart()
                    else -> {
                        println("Exiting Program")
                    }
                }
            } else {
                when (userInput) {
                    "1" -> {
                        ContactListInteractions.searchMenu(); contactListStart()
                    }

                    "2" -> {
                        ContactListInteractions.AddContactEntry(); contactListStart()
                    }

                    "3" -> println("Exiting Program")
                }
            }
        }
    }
}