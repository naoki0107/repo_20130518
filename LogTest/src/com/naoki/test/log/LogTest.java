package com.naoki.test.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Naoki
 *
 */
public class LogTest {
	private static Logger logger = null;
	public static void main(String[] args) {
		init();
		logger.info("Hello");
	}
	private static void init() {
		try {
			logger = Logger.getLogger("com.naoki.test");
			Handler handler = new FileHandler("C:\\Users\\Naoki\\test.log");
			handler.setFormatter(new LogTestFormatter());
			handler.setLevel(Level.INFO);
			Handler handler2 = new ConsoleHandler();
			handler2.setFormatter(new LogTestFormatter());
			handler2.setLevel(Level.INFO);
			logger.addHandler(handler);
			logger.addHandler(handler2);
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}
}
