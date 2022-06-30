package dao;

import java.util.HashMap;
import java.util.Map;

import model.Contact;
import model.Relationship;
import tools.File;

public class ContactDao {

	private static Map<String, Contact> contacts = new HashMap<String, Contact>();
	final static private String FILE_PATH = "contacts.txt";

	public static void addContact(Contact contact) {
		contacts.put(contact.getName(), contact);
	}

	public static Map<String, Contact> getAll() {
		return contacts;
	}

	public static Map<String, Contact> getContactsBeginningByCharacter(char character) {
		Map<String, Contact> contactsBeginningByCharacter = new HashMap<String, Contact>();
		char firstChar;
		for (String key : contacts.keySet()) {
			firstChar = contacts.get(key).getName().charAt(0);
			if (firstChar == character) {
				contactsBeginningByCharacter.put(key, contacts.get(key));
			}
		}
		return contactsBeginningByCharacter;
	}

	public Map<String, Contact> getContactsWithRelationship(Relationship relationship) {
		Map<String, Contact> contactsWithRelationsip = new HashMap<String, Contact>();
		for (String key : contacts.keySet()) {
			Relationship contactRelationship = contacts.get(key).getRelationship();
			if (contactRelationship.equals(relationship)) {
				contactsWithRelationsip.put(key, contacts.get(key));
			}
		}
		return contactsWithRelationsip;
	}

	public static void loadAll() {
		contacts = File.getMapContact(FILE_PATH);
	}

	public static void saveAll() {
		File.writeMapContact(contacts, FILE_PATH);
	}

}
