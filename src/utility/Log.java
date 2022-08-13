package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	private static Logger logger = LogManager.getLogger();

	public static void error(Exception e) {
		logger.error(e);
	}

	public static void info(String information) {
		logger.info(information);
	}

}
