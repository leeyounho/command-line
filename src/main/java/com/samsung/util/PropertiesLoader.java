package com.samsung.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Properties properties = new Properties();

    public PropertiesLoader(String fileName) {
        try {
            InputStream inputStream = PropertiesLoader.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException exception) {
            LOGGER.error("Properties loading failed", exception);
        }
        LOGGER.debug("PropertiesLoader Created");
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
