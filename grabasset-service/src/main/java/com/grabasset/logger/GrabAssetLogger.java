package com.grabasset.logger;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class GrabAssetLogger {
	private static Logger logger;

	private GrabAssetLogger(Class<?> clazz) {
		logger = Logger.getLogger(clazz);
	}

	public static GrabAssetLogger getLogger(Class<?> clazz) {
		return new GrabAssetLogger(clazz);
	}

	public void log(Level prority, String message) {
		logger.log(prority, message);
	}

	public void error(Object message) {
		logger.error(message);
	}

	public void debug(Object message) {
		logger.debug(message);
	}

	public void info(Object message) {
		logger.info(message);
	}

	public void removeAppender(Appender appender) {
		logger.removeAppender(appender);
	}

}
