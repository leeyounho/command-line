package com.samsung.command;

import com.samsung.cache.Cache;
import com.samsung.database.SessionFactoryWrapper;
import com.samsung.di.annotation.ErrorLogger;
import com.samsung.threadpool.ThreadPoolWrapper;
import com.samsung.util.ApplicationPropertyLoader;
import com.samsung.util.ConsoleLogger;
import com.samsung.util.MyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

// Example Class
public final class HelloWorld extends PicoCommandHandler {
    private static final Logger LOGGER = LogManager.getLogger(HelloWorld.class);

    @Inject
    public HelloWorld(ConsoleLogger consoleLogger, @ErrorLogger ConsoleLogger errorLogger, ApplicationPropertyLoader applicationPropertyLoader, MyUtil myUtil, Cache cache, ThreadPoolWrapper threadPoolWrapper, SessionFactoryWrapper sessionFactoryWrapper) {
        LOGGER.debug("Initializing HelloWorldCommand");

        consoleLogger.info("test");
        errorLogger.info("test_error");

        System.out.println(applicationPropertyLoader.getProperty("TEST_123"));
    }

    @Override
    public int handleArgs(String... args) {
        LOGGER.info("world!");
        return 0;
    }
}