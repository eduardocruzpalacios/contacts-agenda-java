package services;

import java.util.Map;

import dao.ContactDao;
import form.ContactForm;
import form.RelationshipForm;
import model.Contact;
import model.Relationship;
import tools.In;
import tools.Log;
import tools.Print;

public class ContactServiceImpl implements ContactService {

	ContactDao contactDao = new ContactDao();

	@Override
	public void create() {
		Contact contact = ContactForm.getContact();
		this.contactDao.addContact(contact);
		Print.str("Contact added successfully");
		Log.logger.info("NEW CONTACT: " + contact);
	}

	@Override
	public void findAll() {
		Print.str("\nALL CONTACTS\n");
		Map<String, Contact> contacts = ContactDao.getAll();
		Print.mapContact(contacts);
		Log.logger.info("FIND ALL CONTACTS");
	}

	@Override
	public void filterByFirstLetter() {
		char userChar = In.getChar("char:");
		Print.str("\nCONTACTS BEGINNING BY " + userChar + "\n");
		Map<String, Contact> contacts = this.contactDao.getContactsBeginningByCharacter(userChar);
		Print.mapContact(contacts);
		Log.logger.info("FIND ALL CONTACTS BEGINNIG BY " + userChar);
	}

	@Override
	public void filterByRelationship() {
		Relationship relationship = RelationshipForm.getRelationship();
		Print.str("\nCONTACTS FROM RELANTIONSHIP " + relationship + "\n");
		Map<String, Contact> contacts = this.contactDao.getContactsWithRelationship(relationship);
		Print.mapContact(contacts);
		Log.logger.info("FIND ALL CONTACTS WITH RELATIONSHIP " + relationship);
	}

	@Override
	public void importAll() {
		ContactDao.loadAll();
	}

	@Override
	public void exportAll() {
		ContactDao.saveAll();
	}

}
