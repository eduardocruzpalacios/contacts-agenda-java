package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.Menu;
import gui.Window;
import services.ContactServiceImpl;
import tools.In;

public class Flow {

	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(Flow.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	public static void exe() {

		Window.start();
		logger.info("agenda started");
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		contactServiceImpl.load();
		logger.info("load()");

		boolean exit = false;
		int option = 0;
		do {
			Menu.main();
			option = In.getIntBetween(1, 5, "Choose an option");
			switch (option) {
			case 1:
				contactServiceImpl.add();
				logger.info("add()");
				break;
			case 2:
				contactServiceImpl.findAll();
				logger.info("findAll()");
				break;
			case 3:
				contactServiceImpl.filterByFirstLetter();
				logger.info("filterByFirstLetter()");
				break;
			case 4:
				contactServiceImpl.filterByGroup();
				logger.info("filterByGroup()");
				break;
			case 5:
				exit = true;
				break;
			}

		} while (!exit);

		contactServiceImpl.save();
		logger.info("save()");

		Window.exit();
		logger.info("agenda finished");
	}

}
