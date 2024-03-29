package controller;

import service.ContactServiceImpl;
import utility.Log;
import view.DataForm;
import view.Menu;
import view.Window;

public class ContactsAgendaController {

	private ContactServiceImpl contactServiceImpl = new ContactServiceImpl();

	public void run() {
		Log.info("APPLICATION STARTED");
		Window.start();
		contactServiceImpl.importAll();
		boolean exit = false;
		int option = 0;
		do {
			Menu.main();
			option = DataForm.getIntBetween(1, 5, "Choose an option");
			switch (option) {
			case 1:
				contactServiceImpl.create();
				break;
			case 2:
				contactServiceImpl.findAll();
				break;
			case 3:
				contactServiceImpl.filterByFirstLetter();
				break;
			case 4:
				contactServiceImpl.filterByRelationship();
				break;
			case 5:
				exit = true;
				break;
			}
		} while (!exit);
		DataForm.closeScanner();
		contactServiceImpl.exportAll();
		Window.exit();
	}

}
