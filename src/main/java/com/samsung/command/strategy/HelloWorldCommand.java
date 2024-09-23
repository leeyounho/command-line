package com.samsung.command.strategy;

import com.samsung.command.Result;
import com.samsung.util.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public final class HelloWorldCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private final PropertyLoader propertyLoader;

    @Inject
    public HelloWorldCommand(PropertyLoader propertyLoader) {
        LOGGER.debug("HelloWorldCommand Created");
        this.propertyLoader = propertyLoader;
    }

    @Override
    public Result handleInput(List<String> input) {
        LOGGER.info(propertyLoader.getProperty("TEST_123"));
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        LOGGER.info("world!");
        return Result.handled();
    }
}