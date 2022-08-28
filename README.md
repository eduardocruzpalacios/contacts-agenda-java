# Contacts Agenda
Contacts agenda console application built with JDK 11.0.12.
## Functionality
### Contacts
- Import all when starting the application
- Export all when exiting the application
- Create one
- Read and print all
- Filter by first letter and print them
- Filter by relationship and print them
## Architecture
| package    | purpose                                                                                      |
| ---------- | -------------------------------------------------------------------------------------------- |
| model      | models for objects (attributes, constructors, getters, setters & .toString()) and enums      |
| dao        | methods to communicate with data source and perform the tasks demanded by the business logic |
| service    | interfaces with business-logic-oriented methods along with the classes implementing them     |
| controller | the flow of the application                                                                  |
| view       | information showed to the users and requested from them                                      |
| utility    | methods for frequently needs                                                                 |
## Data Structure
| data         | structure                                            |
| ------------ | ---------------------------------------------------- |
| Contact      | String name, String phone, Relationship relationship |
| Relationship | enum                                                 |
| ContactDao   | HashMap<String, Contact>                             |
## Data Source
A .txt file.
## Testing
- Unit tests are made with JUnit 5
- Only model classes are tested
## Libs
 - Log4j-api-2.7.jar
 - Log4j-core-2.7.jar