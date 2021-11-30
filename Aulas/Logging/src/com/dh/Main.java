package com.dh;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
	    logger.info("A whim away!");
	    logger.warn("In the jungle");
	    logger.error("The mighty jungle");
	    logger.fatal("The lion sleeps tonight!");
	    logger.debug("A whiiii-iii-iii-iii-iiim-m-m away!");
    }
}
