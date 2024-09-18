package com.samsung.command.module;

import com.samsung.command.Command;
import com.samsung.command.strategy.LogoutCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
abstract class LogoutCommandModule {
    @Binds
    @IntoMap
    @StringKey("logout")
    abstract Command logoutCommand(LogoutCommand command);
}
