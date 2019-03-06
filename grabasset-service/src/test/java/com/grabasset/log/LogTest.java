package com.grabasset.log;

import org.apache.log4j.Level;

import com.grabasset.logger.GrabAssetLogger;

public class LogTest {

	private static final GrabAssetLogger logger = GrabAssetLogger.getLogger(LogTest.class);

	public static void main(String[] args) {

		logger.log(Level.INFO, "this is log statment");
		logger.info("this is info logger");
	}
}
