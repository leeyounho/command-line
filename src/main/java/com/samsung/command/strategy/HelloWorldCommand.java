package com.samsung.command.strategy;

import com.samsung.command.Command;
import com.samsung.command.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public final class HelloWorldCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    public HelloWorldCommand() {
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        LOGGER.info("world!");
        return Result.handled();
    }
}