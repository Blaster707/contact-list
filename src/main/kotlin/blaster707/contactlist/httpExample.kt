package blaster707.contactlist

class httpExample {
    /*fun httpExample(){
        val app = routes(
            "/hello" bind Method.GET to ::handleHello,
            "/goodbye" bind Method.GET to ::handleGoodbye,
            "/goodbye/{name}" bind Method.GET to ::handleGoodbyeWithPath,
            "/echo" bind Method.POST to ::handleEcho,
            "/people" bind Method.GET to ::handleListPeople,
            "/people" bind Method.POST to ::handleAddPerson,
            "/people" bind Method.PUT to ::handleUpdatePerson,
            "/people/save" bind Method.POST to ::handleSavePeople,

            "/contactlist/all" bind Method.POST to ::handleListAll
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

    fun handleAddPerson(req: Request): Response{
        val json = req.bodyString()
        val person = Json.decodeFromString<PersonX>(json)

        return Response(Status.OK).body(person.lastName)
    }

    fun handleSavePeople(req: Request): Response{
        return Response(Status.NOT_IMPLEMENTED).body("TODO")
    }

    fun handleUpdatePerson(req: Request): Response{
        return Response(Status.NOT_IMPLEMENTED).body("TODO")
    }

    fun handleListAll(req: Request): Response{
        return Response(Status.OK).body(ContactList.contactListAll())
    }

    fun jsonContactList(){
        /*val contactEntryX = contactEntryBuilder()

        println("${contactEntryX.person.firstName}, ${contactEntryX.person.lastName}")
        for (phoneNumber in contactEntryX.phoneNumberList) {
            println(phoneNumber.phoneNumberLabelString())
            println("${phoneNumber.number}\n")
        }
        //println(contactEntryX.addressStringAll(contactEntryX.addressList))*/
        /*val json = """
            [
                {
                    "firstName": "Lucas",
                    "lastName": "Ferguson",
                    "age": 24
                },
                {
                    "firstName": "Da-Jour",
                    "lastName": "Ferguson",
                    "age": 26
                }
            ]
        """.trimIndent()

        val people = Json.decodeFromString<List<PersonX>>(json)
        for (person in people) {
            println(person.firstName)
            println(person.lastName)
            println(person.age)
        }

        val newJson = Json.encodeToString(people)
        println(newJson)

        Files.writeString(Path.of("C:\\Projects\\contacts.json"), newJson)
*/
        val savedJsonContactList = Files.readString(Path.of("C:\\Projects\\contacts.json"))

        val savedContactList = Json.decodeFromString<ContactList>(savedJsonContactList)
        for (contactEntry in savedContactList.array) {
            println(contactEntry.firstName)
            println(contactEntry.lastName)
            println(contactEntry.age)
        }
    }*/
}