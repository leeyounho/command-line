package com.samsung.command.strategy;

import com.samsung.cache.Cache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public final class LoginCommand extends SingleArgCommand {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Cache cache;

    @Inject
    public LoginCommand(Cache cache) {
        LOGGER.debug("Initializing LoginCommand");

        this.cache = cache;
    }

    @Override
    public boolean handleArg(String username) {
        LOGGER.info("{} is logged in.", username);
        return true;
    }
}
