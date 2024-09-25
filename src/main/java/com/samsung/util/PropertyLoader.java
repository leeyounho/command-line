package com.samsung.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Properties properties = new Properties();

    public PropertyLoader(String fileName) {
        LOGGER.debug("Initializing PropertiesLoader");
        try {
            InputStream inputStream = PropertyLoader.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException exception) {
            LOGGER.error("Properties loading failed", exception);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
