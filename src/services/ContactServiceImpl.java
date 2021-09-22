package services;

import dao.ContactDao;

public class ContactServiceImpl implements ContactService {

	ContactDao contactDao = new ContactDao();

	@Override
	public void add() {
		this.contactDao.addContact();
	}

	@Override
	public void findAll() {
		this.contactDao.listContacts();
	}

	@Override
	public void filterByFirstLetter() {
		this.contactDao.listContactsBeginningByChar();
	}

	@Override
	public void filterByGroup() {
		this.contactDao.listContactsFromRelationship();
	}

	@Override
	public void load() {
		this.contactDao.loadContacts();
	}

	@Override
	public void save() {
		this.contactDao.saveContacts();
	}

}
