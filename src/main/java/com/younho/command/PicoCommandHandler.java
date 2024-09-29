package com.younho.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

public abstract class PicoCommandHandler {
    protected static final Logger LOGGER = LogManager.getLogger(PicoCommandHandler.class);

    public int handleArgs(String... args) {
        return new CommandLine(this).execute(args);
    }
}