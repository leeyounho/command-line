package com.samsung.di.module.command;

import com.samsung.command.strategy.Command;
import com.samsung.command.strategy.LogoutCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class LogoutCommandModule {
    @Binds
    @IntoMap
    @StringKey("logout")
    abstract Command logoutCommand(LogoutCommand command);
}
