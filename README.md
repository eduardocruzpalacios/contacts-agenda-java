# Contacts Agenda
Contacts agenda built with JDK 11.0.12.

## Architecture
|package|purpose|
|----------------|-------------------------------|
|model|models for objects (attributes, constructors, getters, setters & .toString()) and enums|
|dao|methods to communicate with data source and perform the tasks demanded by the business logic|
|form|methods to ask the user for data to instantiate objects|
|services|interfaces with business-logic-oriented methods along with the classes implementing them|
|control|the flow of the application and the execution class|
|gui|Graphic User Interface|
|tools|methods for frequently needs|

## Functions
 - List all contacts
 - Add a new contact
 - Filter contacts by first letter
 - Filter contacts by relationship
 - Save changes in the agenda when closing the application
 - Load contacts on the agenda when starting the application

## Data Source
A .txt file

## Data Structure
|data|structure|
|----------------|-------------------------------|
|Agenda|HashMap<String, Contact>|
|Contact|String name, String phone, Relationship relationship|
|Relationship|enum|

## Testing
- Unit tests are made with JUnit 5
- Only model classes are tested

## Libs
 - Log4j-api-2.7.jar
 - Log4j-core-2.7.jar
