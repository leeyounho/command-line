package com.samsung.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Cache {
    private static final Logger LOGGER = LogManager.getLogger(Cache.class);

    @Inject
    public Cache() {
        LOGGER.debug("Initializing Cache");
    }
}
