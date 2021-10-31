package tools;

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

	public static Map<String, Contact> getMapContact(String path) {
		Map<String, Contact> contacts = new HashMap<String, Contact>();
		String fileLine;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while ((fileLine = reader.readLine()) != null) {
				Contact contact = new Contact();
				String[] contactAttribute = new String[3];
				contactAttribute = fileLine.split(",");
				contact.setName(contactAttribute[0]);
				contact.setPhone(contactAttribute[1]);
				Relationship relationship = Relationship.valueOf(contactAttribute[2]);
				contact.setRelationship(relationship);
				contacts.put(contact.getName(), contact);
			}
			reader.close();
		} catch (IOException e) {
			Log.logger.error(e);
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
			Log.logger.error(e);
		}
	}

}
