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

	@Override
	public void create() {
		Contact contact = ContactForm.getContact();
		ContactDao.addContact(contact);
		PrintData.string("Contact added successfully");
		Log.info("NEW CONTACT: " + contact);
	}

	@Override
	public void findAll() {
		PrintData.string("\nALL CONTACTS\n");
		Map<String, Contact> contacts = ContactDao.getAll();
		PrintData.contacts(contacts);
		Log.info("FIND ALL CONTACTS");
	}

	@Override
	public void filterByFirstLetter() {
		char userChar = DataForm.getChar("char:");
		PrintData.string("\nCONTACTS BEGINNING BY " + userChar + "\n");
		Map<String, Contact> contacts = ContactDao.getContactsBeginningByCharacter(userChar);
		PrintData.contacts(contacts);
		Log.info("FIND ALL CONTACTS BEGINNIG BY " + userChar);
	}

	@Override
	public void filterByRelationship() {
		Relationship relationship = RelationshipForm.getRelationship();
		PrintData.string("\nCONTACTS FROM RELANTIONSHIP " + relationship + "\n");
		Map<String, Contact> contacts = ContactDao.getContactsWithRelationship(relationship);
		PrintData.contacts(contacts);
		Log.info("FIND ALL CONTACTS WITH RELATIONSHIP " + relationship);
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
