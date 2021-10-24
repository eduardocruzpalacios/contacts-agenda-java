package dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.Flow;
import exceptions.RelationshipNotFoundException;
import gui.Menu;
import model.Contact;
import model.Relationship;
import tools.File;
import tools.In;
import tools.Out;

public class ContactDao {

	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(Flow.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	private static Map<String, Contact> contacts = new HashMap<String, Contact>();
	final static private String FILE_PATH = "contacts.txt";

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

		} catch (RelationshipNotFoundException e) {
			logger.warn(e + " " + relationshipString);
		}
		contacts.put(contact.getName(), contact);
		logger.info(contact);
		Out.printString("Contact added successfully");
	}

	public void listContacts() {
		Out.printString("\n***** ALL CONTACTS *****");
		for (Object object : contacts.keySet()) {
			System.out.println(object + " -> " + contacts.get(object));
		}
	}

	public void listContactsBeginningByChar() {
		String userChar = In.getChar("Write a char");
		Out.printString("\n***** CONTACTS BEGINNING BY " + userChar + " *****");
		for (Object object : contacts.keySet()) {
			String key = (String) object;
			String firstChar = contacts.get(object).getName();
			if (userChar.toLowerCase().charAt(0) == firstChar.toLowerCase().charAt(0)) {
				Contact value = contacts.get(key);
				System.out.println(key + " -> " + value);
			}
		}
	}

	public void listContactsFromRelationship() {
		Menu.relationshipListed();
		Relationship relationship = Relationship.valueOf(In.getString("Choose a group").toUpperCase());
		Out.printString("\n***** CONTACTS FROM GROUP " + relationship + " *****");
		for (Object object : contacts.keySet()) {
			String key = (String) object;
			Relationship objectRelationship = contacts.get(object).getRelationship();
			if (objectRelationship.equals(relationship)) {
				Contact value = contacts.get(key);
				System.out.println(key + " -> " + value);
			}
		}
	}

	public void loadContacts() {
		contacts = File.loadContacts(FILE_PATH);
	}

	public void saveContacts() {
		File.saveContacts(contacts, FILE_PATH);
	}

}
