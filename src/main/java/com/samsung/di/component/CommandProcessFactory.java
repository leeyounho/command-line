package com.samsung.di.component;

import com.samsung.command.CommandProcessor;
import com.samsung.di.annotation.CommandScope;
import com.samsung.di.module.command.HelloWorldModule;
import com.samsung.di.module.command.LoginCommandModule;
import dagger.Subcomponent;


@CommandScope
@Subcomponent(
        modules = {
                LoginCommandModule.class,
                HelloWorldModule.class,
                UserCommandsRouter.InstallationModule.class,
        })
public interface CommandProcessFactory {
    CommandProcessor commandProcessor();

    @Subcomponent.Factory
    interface Factory {
        CommandProcessFactory create();
    }
}
