package form;

import model.Contact;
import model.Relationship;
import tools.In;
import tools.Print;

public class ContactForm {

	public static Contact getContact() {
		Print.str("Let's create a new contact");
		String name = In.getString("Choose a name");
		String phone = In.getString("Write the phone");
		Relationship relationship = Relationship.getRelationship("Choose a Relationship");
		Contact contact = new Contact(name, phone, relationship);
		return contact;
	}

}
