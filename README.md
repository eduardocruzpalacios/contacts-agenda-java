# Contacts Agenda
Contacts agenda built with Java 11.

## Architecture
|package|purpose|
|----------------|-------------------------------|
|model|offers a model for objects (attributes, constructors, getters, setters & .toString()) and includes an enum|
|dao|guarantees the data persistence, including the CRUD operations|
|services|interfaces with business-logic-oriented methods along with the classes implementing them|
|control|the flow of the application and the execution class|
|gui|the graphics|
|tools|static methods for frequently needs as asking for a integer to the user|
|exceptions|personalized exceptions|

## Functions
Given an agenda with contacts:
 - List all contacts
 - Add a new contact
 - Filter contacts by their first letter
 - Filter contacts by their group
 - Save changes in the agenda when closing the application
 - Load contacts on the agenda when starting the application

Saving and loading operations work with a .txt file

## Data Structure
|data|structure|
|----------------|-------------------------------|
|Agenda|HashMap<String, Contact>|
|Contact|String name, String phone, Relationship relationship|
|Relationship|enum|

## Libs
 - Log4j-api-2.7.jar
 - Log4j-core-2.7.jar
