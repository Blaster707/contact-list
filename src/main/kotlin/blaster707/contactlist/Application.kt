package blaster707.contactlist

import kotlinx.serialization.Serializable
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
            false -> ContactList(mutableListOf())
        }

        for (contactEntry in contactList.contacts) {
            println(contactEntry.firstName)
            println(contactEntry.lastName)
            println(contactEntry.age)
        }

        val app = routes(
            "/hello" bind Method.GET to ::handleHello,
            "/goodbye" bind Method.GET to ::handleGoodbye,
            "/goodbye/{name}" bind Method.GET to ::handleGoodbyeWithPath,
            "/echo" bind Method.POST to ::handleEcho,

            "/contactlist" bind Method.GET to ::handleListAll,
            "/contactlist" bind Method.POST to ::handleAddContactEntry,
            "/contactlist" bind Method.PUT to ::handleUpdatePerson,
            "/contactlist/save" bind Method.POST to ::handleSavePeople

        )


        val server = app.asServer(Undertow(8080)).start()

        Thread.sleep(Long.MAX_VALUE)
        server.stop()

    }

    fun handleHello(req: Request): Response{
        return Response(Status.OK).body("Hello from Lucas")
    }

    fun handleGoodbye(req: Request): Response{
        return Response(Status.OK).body("Goodbye ${req.query("name")}")
    }

    fun handleGoodbyeWithPath(req: Request): Response{
        return Response(Status.OK).body("Goodbye ${req.path("name")} from path")
    }

    fun handleEcho(req: Request): Response{
        return Response(Status.OK).body(req.body)
    }

    fun handleListPeople(req: Request): Response{
        val people = listOf(
            PersonX("Lucas", "Ferguson", 24),
            PersonX("Da-Jour", "Ferguson", 26)
        )

        val json = Json.encodeToString(people)

        return Response(Status.OK).body(json)
    }

    fun handleAddContactEntry(req: Request): Response{
        val json = req.bodyString()
        val contactDetail = Json.decodeFromString<ContactDetail>(json)
        lastId += 1
        val contactEntry = ContactEntry(lastId.toString(), contactDetail.person, contactDetail.addressList, contactDetail.phoneNumberList)
        contactList.contacts.add(contactEntry)
        return Response(Status.OK).body(contactEntry.id)
    }

    fun handleSavePeople(req: Request): Response{
        return Response(Status.NOT_IMPLEMENTED).body("TODO")
    }

    fun handleUpdatePerson(req: Request): Response{
        return Response(Status.NOT_IMPLEMENTED).body("TODO")
    }

    fun handleListAll(req: Request): Response{
        val summaries = contactList.contacts.map { it.toSummary() }
        return Response(Status.OK).body(Json.encodeToString(summaries))
    }


}

@Serializable
data class PersonX (val firstName: String, val lastName: String, val age: Int? = null)