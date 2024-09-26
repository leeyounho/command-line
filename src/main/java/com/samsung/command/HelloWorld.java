package com.samsung.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public final class HelloWorld implements CommandHandler {
    private static final Logger LOGGER = LogManager.getLogger(HelloWorld.class);

    @Inject
    public HelloWorld() {
        LOGGER.debug("Initializing HelloWorldCommand");
    }

    @Override
    public int handleArgs(String... args) {
        LOGGER.info("world!");
        return 0;
    }
}