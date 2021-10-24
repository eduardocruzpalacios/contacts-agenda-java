package dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import exceptions.RelationshipNotFoundException;
import gui.Menu;
import model.Contact;
import model.Relationship;
import tools.File;
import tools.In;
import tools.Out;

public class ContactDao {

	private static Logger logger;

	private Map<String, Contact> contacts = new HashMap<String, Contact>();
	private String filePath = "contacts.txt";

	public void addContact() {

		Out.printString("First, let's create a new contact");
		Contact contact = new Contact();

		contact.setName(In.getString("Choose a name"));
		contact.setPhone(In.getString("Write the phone"));

		Menu.relationshipListed();
		String relationshipString = In.getString("Choose a group").toUpperCase();

		try {
			int count = 0;
			for (Relationship relationship : Relationship.BY_ID.values()) {
				count++;
				if (relationship.toString().equals(relationshipString)) {
					break;
				}
				if (count == Relationship.BY_ID.size()) {
					throw new RelationshipNotFoundException();
				}
			}
			Relationship relationship = Relationship.valueOf(relationshipString);
			contact.setRelationship(relationship);
			this.contacts.put(contact.getName(), contact);
			logger.info(contact);
			Out.printString("Contact added successfully");

		} catch (RelationshipNotFoundException e) {
			logger.warn(e + " " + relationshipString);
		}

	}

	public void listContacts() {
		Out.printString("\n***** ALL CONTACTS *****");
		for (Object object : this.contacts.keySet()) {
			System.out.println(object + " -> " + this.contacts.get(object));
		}
	}

	public void listContactsBeginningByChar() {
		String userChar = In.getChar("Write a char");
		Out.printString("\n***** CONTACTS BEGINNING BY " + userChar + " *****");
		for (Object object : this.contacts.keySet()) {
			String key = (String) object;
			String firstChar = this.contacts.get(object).getName();
			if (userChar.toLowerCase().charAt(0) == firstChar.toLowerCase().charAt(0)) {
				Contact value = this.contacts.get(key);
				System.out.println(key + " -> " + value);
			}
		}
	}

	public void listContactsFromRelationship() {
		Menu.relationshipListed();
		Relationship relationship = Relationship.valueOf(In.getString("Choose a group").toUpperCase());
		Out.printString("\n***** CONTACTS FROM GROUP " + relationship + " *****");
		for (Object object : this.contacts.keySet()) {
			String key = (String) object;
			Relationship objectRelationship = this.contacts.get(object).getRelationship();
			if (objectRelationship.equals(relationship)) {
				Contact value = this.contacts.get(key);
				System.out.println(key + " -> " + value);
			}
		}
	}

	public void loadContacts() {
		this.contacts = File.loadContacts(this.filePath);
	}

	public void saveContacts() {
		File.saveContacts(this.contacts, this.filePath);
	}

}
