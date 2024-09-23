package com.samsung.component;

import com.samsung.command.CommandProcessor;
import com.samsung.command.module.HelloWorldModule;
import com.samsung.command.module.LoginCommandModule;
import com.samsung.util.module.ConfigModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {
                LoginCommandModule.class,
                HelloWorldModule.class,
                UserCommandsRouter.InstallationModule.class,
                ConfigModule.class,
        })
public interface AppComponentFactory {
    CommandProcessor commandProcessor();
}
