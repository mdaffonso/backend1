package com.dh;

import org.apache.log4j.PropertyConfigurator;

public class Logger {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());
    public Logger() {
        PropertyConfigurator.configure("log4j.properties");
    }
}
