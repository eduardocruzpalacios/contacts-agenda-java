package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.AgendaController;

public class Log {

	private static Logger logger = LogManager.getLogger(AgendaController.class);

	public static void error(Exception e) {
		logger.error(e);
	}

	public static void info(String information) {
		logger.info(information);
	}

}
