package com.dh;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static final Logger logger = Logger.getLogger(Average.class);

    private static final void generateLog(Average numbers) throws Exception {
        PropertyConfigurator.configure("log4j.properties");

        if (numbers.getLength() == 0) {
            logger.error("A lista não tem elementos");
            throw new Exception();
        }

        if (numbers.getLength() > 5) {
            logger.info("A lista tem mais de 5 números");
        } else if (numbers.getLength() > 10) {
            logger.info("A lista tem mais de 10 números");
        }

        logger.info(numbers.getAverage().toString());
    }

    public static void main(String[] args) {
	    Average numbers = new Average(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        System.out.println(numbers.toString());
        generateLog(numbers);
    }
}
