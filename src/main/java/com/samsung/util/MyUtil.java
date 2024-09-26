package com.samsung.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class MyUtil {
    private static final Logger LOGGER = LogManager.getLogger(MyUtil.class);

    @Inject
    public MyUtil() {
        LOGGER.debug("Initializing MyUtil");
    }
}
