package com.samsung.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final Logger LOGGER = LogManager.getLogger();

    public Properties loadProperties(String fileName) {
        try {
            Properties configuration = new Properties();
            InputStream inputStream = PropertiesLoader.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);
            configuration.load(inputStream);
            inputStream.close();
            return configuration;
        } catch (IOException exception){
            LOGGER.error("Properties loading failed", exception);
        }
        return null;
    }
}
