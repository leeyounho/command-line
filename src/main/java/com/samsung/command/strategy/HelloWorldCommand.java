package com.samsung.command.strategy;

import com.samsung.command.Command;
import com.samsung.command.Result;
import com.samsung.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.Properties;

public final class HelloWorldCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private final PropertiesLoader propertiesLoader;

    @Inject
    public HelloWorldCommand(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
        LOGGER.debug("HelloWorldCommand Created");
    }

    @Override
    public Result handleInput(List<String> input) {
        LOGGER.info(propertiesLoader.getProperty("TEST_123"));
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        LOGGER.info("world!");
        return Result.handled();
    }
}