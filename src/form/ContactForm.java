package form;

import model.Contact;
import model.Relationship;
import tools.In;
import tools.Print;

public class ContactForm {

	public static Contact getContact() {
		Print.str("CONTACT FORM");
		String name = In.getString("name:");
		String phone = In.getString("phone:");
		Relationship relationship = RelationshipForm.getRelationship();
		Contact contact = new Contact(name, phone, relationship);
		return contact;
	}

}
