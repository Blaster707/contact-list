# ContactList Design Feedback

## Domain Class Feedback

### General Feedback

- Seperate file created for Person - but ContactEntry has a lot of different classes built into it.
  - utilize refactoring capabilities of IDE to extract PhoneNumber, Address, etc. - Done 11/24/22
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

- on lines 5 and 6, default for addressList and phoneNumberList are mutableList - should be emptyList() - Done 11/24/22
- ContactEntry can iterate over all addresses and produce string for each - Done 11/24/22
  - in Address, function produces a string from an address

### Phone Number

- Q: does a phone number need to be a long?  No - it should be a string - Done 11/24/22
  - if you are not going to do math on it, not an int or a long or byte, etc., should be a string
- PhoneNumber has user interface logic in it, limiting where PhoneNumber can be used - move to Builder - Done 11/24/22
  - vars should not be in data classes, use vals only - Done 11/24/22

### Address

- zipCode does not need to be an int - Done 11/24/22
- addressLabelString
  - move addressBuilder to Builder - Done 11/24/22

### LocationLabel

- bad form to use name of type as part of the name of a variable (eg. labelString vs. label)
- location label's description is "home" instead of labelString is "home" - Done 11/24/22

## Builder Logic Feedback

- inconsistent heuristic for placement of builder logic - Adjusted 11/24/22
- name should be more specific (ContactFieldBuilder vs Builder) - Done 11/24/22
- no need to create instances of builder; builder is just grouping builder functions together - Builder is now object 11/24/22
  - Builder should be an object, not a class - 11/24/22
- numberBuilder is not necessary as zip code and phoneNumber are going to be strings - eliminated 11/24/22


