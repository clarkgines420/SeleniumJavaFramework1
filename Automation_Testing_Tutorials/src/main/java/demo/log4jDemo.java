package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jDemo {
	
	private static final Logger logger = LogManager.getLogger(log4jDemo.class);

	public static void main(String[] args) {
		
		System.out.println("hilu wurld   \n");
		
		logger.trace("This is a trace message");
		logger.info("This is an information message");
		logger.error("This is an error message");
		logger.warn("This is a warning message");
		logger.fatal("This is a fatal error message");
		
		System.out.println("\n    Completed");
		
	}

}
