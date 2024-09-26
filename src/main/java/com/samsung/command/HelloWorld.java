package com.samsung.command;

import com.samsung.cache.Cache;
import com.samsung.threadpool.ThreadPoolWrapper;
import com.samsung.util.MyUtil;
import com.samsung.util.ApplicationPropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public final class HelloWorld extends PicoCommandHandler {
    private static final Logger LOGGER = LogManager.getLogger(HelloWorld.class);

    @Inject
    public HelloWorld(ApplicationPropertyLoader applicationPropertyLoader, MyUtil myUtil, Cache cache, ThreadPoolWrapper threadPoolWrapper) {
        LOGGER.debug("Initializing HelloWorldCommand");

        System.out.println(applicationPropertyLoader.getProperty("TEST_123"));
    }

    @Override
    public int handleArgs(String... args) {
        LOGGER.info("world!");
        return 0;
    }
}