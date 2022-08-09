package view;

import model.Contact;
import model.Relationship;

public class ContactForm {

	public static Contact getContact() {
		PrintData.str("CONTACT FORM");
		String name = DataForm.getString("name:");
		String phone = DataForm.getString("phone:");
		Relationship relationship = RelationshipForm.getRelationship();
		Contact contact = new Contact(name, phone, relationship);
		return contact;
	}

}
