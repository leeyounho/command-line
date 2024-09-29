package com.samsung.di.module;

import com.samsung.di.annotation.ErrorLogger;
import com.samsung.util.ConsoleLogger;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ConsoleModule {
    @Provides
    public static ConsoleLogger consoleOutLogger() {
        return System.out::println;
    }

    @Provides
    @ErrorLogger
    public static ConsoleLogger consoleErrorLogger() {
        return System.err::println;
    }
}
