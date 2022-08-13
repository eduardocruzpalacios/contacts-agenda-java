package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Contact;
import model.Relationship;

public class File {

	public static Map<String, Contact> getContactsFromFile(String filePath) {
		Map<String, Contact> contacts = new HashMap<String, Contact>();
		String fileLine;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((fileLine = reader.readLine()) != null) {

				String[] contactAttribute = new String[3];
				contactAttribute = fileLine.split(",");
				String name = contactAttribute[0];
				String phone = contactAttribute[1];
				Relationship relationship = Relationship.valueOf(contactAttribute[2]);
				Contact contact = new Contact(name, phone, relationship);
				contacts.put(contact.getName(), contact);
			}
			reader.close();
		} catch (IOException e) {
			Log.error(e);
		}
		return contacts;
	}

	public static void writeMapContact(Map<String, Contact> contacts, String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			for (Object object : contacts.keySet()) {
				Contact contact = contacts.get(object);
				writer.write(contact.getName() + "," + contact.getPhone() + "," + contact.getRelationship());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			Log.error(e);
		}
	}

}
