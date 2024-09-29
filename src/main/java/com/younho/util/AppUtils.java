package com.younho.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class AppUtils {
    private static final Logger LOGGER = LogManager.getLogger(AppUtils.class);

    @Inject
    public AppUtils() {
        LOGGER.debug("Initializing AppUtils");
    }
}
