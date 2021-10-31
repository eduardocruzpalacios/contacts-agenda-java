package services;

import dao.ContactDao;
import model.Contact;
import model.Relationship;
import tools.In;
import tools.Log;
import tools.Print;

public class ContactServiceImpl implements ContactService {

	ContactDao contactDao = new ContactDao();

	@Override
	public void create() {
		Print.str("Let's create a new contact");
		Contact contact = new Contact();
		contact.setName(In.getString("Choose a name"));
		contact.setPhone(In.getString("Write the phone"));
		Relationship relationship = Relationship.getRelationship("Choose a Relationship");
		contact.setRelationship(relationship);
		if (!this.contactDao.existContact(contact.getName())) {
			this.contactDao.addContact(contact);
			Print.str("Contact added successfully");
			Log.logger.info("NEW CONTACT: " + contact);
		} else {
			Print.str("Contact already existed and not added");
		}
	}

	@Override
	public void findAll() {
		Print.str("\n***** ALL CONTACTS *****");
		Print.mapContact(this.contactDao.getAll());
		Log.logger.info("FIND ALL CONTACTS");
	}

	@Override
	public void filterByFirstLetter() {
		String userChar = In.getChar("Write a char");
		Print.str("\n***** CONTACTS BEGINNING BY " + userChar + " *****");
		Print.mapContact(this.contactDao.getContactsBeginningByCharacter(userChar.charAt(0)));
		Log.logger.info("FIND ALL CONTACTS BEGINNIG BY " + userChar);
	}

	@Override
	public void filterByRelationship() {
		Relationship relationship = Relationship.getRelationship("Choose a Relationship");
		Print.str("\n***** CONTACTS FROM GROUP " + relationship + " *****");
		Print.mapContact(this.contactDao.getContactsWithRelationship(relationship));
		Log.logger.info("FIND ALL CONTACTS WITH RELATIONSHIP " + relationship);
	}

	@Override
	public void importAll() {
		this.contactDao.loadAll();
	}

	@Override
	public void exportAll() {
		this.contactDao.saveAll();
	}

}
