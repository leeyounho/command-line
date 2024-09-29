package com.younho.command;

import com.younho.cache.Cache;
import com.younho.database.SessionFactoryWrapper;
import com.younho.di.annotation.ErrorLogger;
import com.younho.threadpool.ThreadPoolWrapper;
import com.younho.util.ApplicationPropertyLoader;
import com.younho.util.ConsoleLogger;
import com.younho.util.MyUtil;
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