package control;

import services.ContactServiceImpl;
import tools.In;
import tools.Log;
import view.Menu;
import view.Window;

public class Flow {

	public static void exe() {
		Log.logger.info("APPLICATION STARTED");
		Window.start();
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		contactServiceImpl.importAll();
		boolean exit = false;
		int option = 0;
		do {
			Menu.main();
			option = In.getIntBetween(1, 5, "Choose an option");
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
		In.closeScanner();
		contactServiceImpl.exportAll();
		Window.exit();
	}

}
