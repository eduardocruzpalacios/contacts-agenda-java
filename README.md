# Contacts Agenda
Contacts agenda console application built with JDK 11.0.12.

## Architecture
|package|purpose|
|----------------|-------------------------------|
|model|models for objects (attributes, constructors, getters, setters & .toString()) and enums|
|dao|methods to communicate with data source and perform the tasks demanded by the business logic|
|service|interfaces with business-logic-oriented methods along with the classes implementing them|
|controller|the flow of the application|
|view|information showed to the users and requested from them|
|utility|methods for frequently needs|

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
