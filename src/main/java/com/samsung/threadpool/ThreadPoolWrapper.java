package com.samsung.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolWrapper {
    private static final Logger LOGGER = LogManager.getLogger(ThreadPoolWrapper.class);
    private final ExecutorService executor;

    @Inject
    public ThreadPoolWrapper() {
        LOGGER.debug("Initializing ThreadPoolWrapper");

        executor = new ThreadPoolExecutor(
                5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                new ThreadFactoryBuilder()
                        .setNameFormat("CoreExecutor-%d")
                        .setUncaughtExceptionHandler(new ThreadExceptionHandler())
                        .build()
        );
    }

    public void run(Runnable runnable){
        executor.execute(runnable);
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
