package com.samsung.command.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public final class LogoutCommand extends SingleArgCommand {
    private static final Logger LOGGER = LogManager.getLogger();

    @Inject
    public LogoutCommand() {
        LOGGER.debug("Initializing LogoutCommand");
    }

    @Override
    public boolean handleArg(String username) {
        LOGGER.info("logged out {}", username);
        return true;
    }
}
