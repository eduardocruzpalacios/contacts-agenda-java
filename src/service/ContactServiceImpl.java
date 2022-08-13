package service;

import java.util.Map;

import dao.ContactDao;
import model.Contact;
import model.Relationship;
import utility.Log;
import view.ContactForm;
import view.DataForm;
import view.PrintData;
import view.RelationshipForm;

public class ContactServiceImpl implements ContactService {

	private ContactDao contactDao = new ContactDao();

	@Override
	public void create() {
		Contact contact = ContactForm.getContact();
		contactDao.addContact(contact);
		PrintData.string("Contact added successfully");
		Log.info("NEW CONTACT: " + contact);
	}

	@Override
	public void findAll() {
		PrintData.string("\nALL CONTACTS\n");
		Map<String, Contact> contacts = contactDao.getAll();
		PrintData.contacts(contacts);
		Log.info("FIND ALL CONTACTS");
	}

	@Override
	public void filterByFirstLetter() {
		char userChar = DataForm.getChar("char:");
		PrintData.string("\nCONTACTS BEGINNING BY " + userChar + "\n");
		Map<String, Contact> contactsFilteredByFirstLetter = contactDao.getContactsBeginningByCharacter(userChar);
		PrintData.contacts(contactsFilteredByFirstLetter);
		Log.info("FIND ALL CONTACTS BEGINNIG BY " + userChar);
	}

	@Override
	public void filterByRelationship() {
		Relationship relationship = RelationshipForm.getRelationship();
		PrintData.string("\nCONTACTS FROM RELANTIONSHIP " + relationship + "\n");
		Map<String, Contact> contactsFilteredByRelationship = contactDao.getContactsWithRelationship(relationship);
		PrintData.contacts(contactsFilteredByRelationship);
		Log.info("FIND ALL CONTACTS WITH RELATIONSHIP " + relationship);
	}

	@Override
	public void importAll() {
		contactDao.loadAll();
	}

	@Override
	public void exportAll() {
		contactDao.saveAll();
	}

}
