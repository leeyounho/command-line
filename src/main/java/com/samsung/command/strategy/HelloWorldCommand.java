package com.samsung.command.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public final class HelloWorldCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    public HelloWorldCommand() {
        LOGGER.debug("Initializing HelloWorldCommand");
    }

    @Override
    public boolean handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return false;
        }
        LOGGER.info("world!");
        return true;
    }
}