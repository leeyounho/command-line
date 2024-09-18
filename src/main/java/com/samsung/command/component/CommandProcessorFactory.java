package com.samsung.command.component;

import com.samsung.command.CommandProcessor;
import com.samsung.command.module.HelloWorldModule;
import com.samsung.command.module.LoginCommandModule;
import com.samsung.command.module.SystemOutModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {
                LoginCommandModule.class,
                HelloWorldModule.class,
                SystemOutModule.class,
                UserCommandsRouter.InstallationModule.class,
        })
public interface CommandProcessorFactory {
    CommandProcessor commandProcessor();
}
