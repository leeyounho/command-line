package com.samsung.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertyLoader {
    private static final Logger LOGGER = LogManager.getLogger(ApplicationPropertyLoader.class);
    private final Properties properties = new Properties();
    private final String fileName = "application.properties";

    @Inject
    public ApplicationPropertyLoader() {
        LOGGER.debug("Initializing ApplicationPropertiesLoader");

        try {
            InputStream inputStream = ApplicationPropertyLoader.class
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

    public Properties getProperties() {
        return properties;
    }
}
