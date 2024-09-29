package com.younho.di.module;

import com.younho.di.annotation.ErrorLogger;
import com.younho.util.ConsoleLogger;
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
