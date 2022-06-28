package services;

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
		Print.mapContact(this.contactDao.getAll());
		Log.logger.info("FIND ALL CONTACTS");
	}

	@Override
	public void filterByFirstLetter() {
		String userChar = In.getStringOf1Length("Write a char");
		Print.str("\nCONTACTS BEGINNING BY " + userChar + "\n");
		Print.mapContact(this.contactDao.getContactsBeginningByCharacter(userChar.charAt(0)));
		Log.logger.info("FIND ALL CONTACTS BEGINNIG BY " + userChar);
	}

	@Override
	public void filterByRelationship() {
		Relationship relationship = RelationshipForm.getRelationship();
		Print.str("\nCONTACTS FROM RELANTIONSHIP " + relationship + "\n");
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
