package com.samsung.di.module.command;

import com.samsung.command.strategy.CommandHandler;
import com.samsung.command.strategy.HelloWorld;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class HelloWorldModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract CommandHandler helloWorld(HelloWorld command);
}
