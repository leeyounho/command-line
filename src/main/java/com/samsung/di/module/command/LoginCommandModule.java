package com.samsung.di.module.command;

import com.samsung.command.strategy.Command;
import com.samsung.command.strategy.LoginCommand;
import com.samsung.cache.entity.Account;
import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    abstract Command loginCommand(LoginCommand command);

    @BindsOptionalOf
    abstract Account optionalAccount();
}
