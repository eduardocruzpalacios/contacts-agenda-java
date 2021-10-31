package tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.Flow;

public class Log {

	public static Logger logger;

	static {
		try {
			logger = LogManager.getLogger(Flow.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

}
