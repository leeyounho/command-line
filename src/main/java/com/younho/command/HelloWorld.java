package com.younho.command;

import com.younho.cache.Cache;
import com.younho.database.SessionFactoryWrapper;
import com.younho.di.annotation.ErrorLogger;
import com.younho.threadpool.ThreadPoolWrapper;
import com.younho.util.AppUtils;
import com.younho.util.ApplicationPropertyLoader;
import com.younho.util.ConsoleLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

// Example Class
public final class HelloWorld extends PicoCommandHandler {
    private static final Logger LOGGER = LogManager.getLogger(HelloWorld.class);

    @Inject
    public HelloWorld(ConsoleLogger consoleLogger, @ErrorLogger ConsoleLogger errorLogger, ApplicationPropertyLoader applicationPropertyLoader, AppUtils appUtils, Cache cache, ThreadPoolWrapper threadPoolWrapper, SessionFactoryWrapper sessionFactoryWrapper) {
        LOGGER.debug("Initializing HelloWorldCommand");
    }

    @Override
    public int handleArgs(String... args) {
        LOGGER.info("world!");
        return 0;
    }
}