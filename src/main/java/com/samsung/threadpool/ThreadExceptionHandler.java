package com.samsung.threadpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger(ThreadExceptionHandler.class);

    public ThreadExceptionHandler() {
        LOGGER.debug("Initializing ThreadExceptionHandler");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.error("{} Exception Handled", t.getName(), e);
    }
}
