package blaster707.contactlist

import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.Undertow
import org.http4k.server.asServer
import java.nio.file.Files
import java.nio.file.Path


object Application {

    var contactList = ContactList(mutableListOf())
    var lastId = 0

    @JvmStatic
    fun main(args: Array<String>) {
        //ApplicationJSON.applicationJSON()
        //jsonContactList()

        val fileExists = Files.exists(Path.of("C:\\Projects\\contacts.json"))

        contactList = when(fileExists) {
            true -> {
                val savedJsonContactList = Files.readString(Path.of("C:\\Projects\\contacts.json"))

                val list = Json.decodeFromString<ContactList>(savedJsonContactList)
                lastId = list.contacts.map { it.id.toInt() }.max()
                list
            }
            false -> ContactList(mutableListOf(
                ContactEntry(
                    "0",
                    Person(
                        PersonName("Lucas","Ferguson","Alexander"),
                        24
                    ),
                    listOf(
                        Address(
                            "1234",
                            "Happy Ave",
                            "NiceTown",
                            "MN",
                            "55555-5555",
                            LocationLabel.Other
                        )
                    ),
                    listOf(
                        PhoneNumber(
                            "123-456-7890",
                            LocationLabel.Other
                        )
                    )
                )
            ))
        }

        for (contactEntry in contactList.contacts) {
            println(contactEntry.firstName)
            println(contactEntry.lastName)
            println(contactEntry.age)
        }

        val app = routes(

            "/contactlist" bind Method.GET to ::handleListAll,
            "/contactlist" bind Method.POST to ::handleAddContactEntry,
            "/contactlist" bind Method.PUT to ::handleUpdatePerson,
            "/contactlist" bind Method.DELETE to ::handleDeleteContactEntry,
            "/contactlist/details" bind Method.GET to ::handleListAllDetails,
            "/contactlist/save" bind Method.POST to ::handleSavePeople,
            "/contactlist/{id}" bind Method.GET to ::handleContactEntryDetails,

        )


        val server = app.asServer(Undertow(8080)).start()

        Thread.sleep(Long.MAX_VALUE)
        server.stop()

    }

    fun handleAddContactEntry(req: Request): Response{
        val json = req.bodyString()
        val contactDetail = Json.decodeFromString<ContactDetail>(json)
        lastId += 1
        val contactEntry = ContactEntry(lastId.toString(), contactDetail.person, contactDetail.addressList, contactDetail.phoneNumberList)
        contactList.contacts.add(contactEntry)
        return Response(Status.OK).body(contactEntry.id)
    }

    fun handleDeleteContactEntry(req: Request): Response{
        val contactToDelete = req.bodyString()
        return if (contactList.deleteContactEntry(contactToDelete)) {
            Response(Status.OK).body("Contact Entry with ID $contactToDelete will be deleted on next save.")
        } else Response(Status.NOT_FOUND).body("No Contact Entry with ID $contactToDelete located.")
    }

    fun handleSavePeople(req: Request): Response{
        Files.writeString(Path.of("C:\\Projects\\contacts.json"), Json.encodeToString(contactList))
        return Response(Status.OK).body("Contact List Saved")
    }

    fun handleUpdatePerson(req: Request): Response{
        val contactToUpdate = Json.decodeFromString<ContactEntry>(req.bodyString())
        return if (contactList.deleteContactEntry(contactToUpdate.id)) {
            contactList.contacts.add(contactToUpdate)
            Response(Status.OK).body("Contact Entry with ID ${contactToUpdate.id} will be updated on next save with the following info:\n\n${Json.encodeToString(contactToUpdate)}")
        } else Response(Status.NOT_FOUND).body("No Contact Entry with ID ${contactToUpdate.id} located.")
    }

    fun handleListAll(req: Request): Response{
        val summaries = contactList.contacts.map { it.toSummary() }
        return Response(Status.OK).body(Json.encodeToString(summaries))
    }

    fun handleListAllDetails(req: Request): Response{
        return Response(Status.OK).body(Json.encodeToString(contactList.contacts.toList()))
    }

    fun handleContactEntryDetails(req: Request): Response{
        val contactEntryQueryId = req.path("id")
        for (contactEntry in contactList.contacts) {
            if (contactEntry.id == contactEntryQueryId) {
                return Response(Status.OK).body(Json.encodeToString(contactEntry))
            }
        }
        return Response(Status.NOT_FOUND).body("No Contact Entry with ID $contactEntryQueryId located.")
    }


}