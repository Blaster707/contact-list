# ContactList Design Feedback

## Domain Class Feedback

### General Feedback

- Seperate file created for Person - but ContactEntry has a lot of different classes built into it.
  - utilize refactoring capabilities of IDE to extract PhoneNumber, Address, etc. 
    - refactoring in this case is: extract file; see lightbulb (context actions)
- inconsistent of data class versus class for domain classes (person, address, etc.)
- making a class open should be a very intentional design choice
  - specifically that you intend other classes to inherit from it and add more data or more logic
- !!!don't drive drunk, don't write code when exhausted!!!

### Person Class

- Q: Do you see any data clumps here?  In future, opt. middleName, opt. lastName, jr, sr, etc.
  - perhaps even fields such as age, birthDate, etc. 
  - should firstName and lastName be their own data class (data class Name, for example)

### Contact Entry

- on lines 5 and 6, default for addressList and phoneNumberList are mutableList - should be emptyList()
- ContactEntry can iterate over all addresses and produce string for each
  - in Address, function produces a string from an address

### Phone Number

- Q: does a phone number need to be a long?  No - it should be a string
- if you are not going to do math on it, not an int or a long or byte, etc., should be a string
- PhoneNumber has user interface logic in it, limiting where PhoneNumber can be used - move to Builder
  - vars should not be in data classes, use vals only

### Address

- zipCode does not need to be an int
- addressLabelString
- move addressBuilder to Builder

### LocationLabel

- bad form to use name of type as part of the name of a variable (eg. labelString vs. label)
- location label's description is "home" instead of labelString is "home"

## Builder Logic Feedback

- inconsistent heuristic for placement of builder logic
- name should be more specific (ContactFieldBuilder vs Builder)
- no need to create instances of builder; builder is just grouping builder functions together
- Builder should be an object, not a class
- numberBuilder is not necessary as zip code and phoneNumber are going to be strings


