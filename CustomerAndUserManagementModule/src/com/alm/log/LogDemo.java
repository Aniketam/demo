package com.alm.log;


import org.apache.log4j.Logger;

public class LogDemo {

	/**
	 * @param args
	 */
	private static Logger logger = Logger.getLogger(LogDemo.class.getName());
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.debug("This is a debug message");
		logger.info("This is a information message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");
		logger.debug("This is another debug message");
		logger.info("This is another information message");
		logger.warn("This is another warning message");
		logger.error("This is another error message");
		logger.fatal("This is another fatal message");
		System.out.println("Hello");
	}

}
