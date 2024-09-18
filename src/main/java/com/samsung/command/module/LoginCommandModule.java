package com.samsung.command.module;

import com.samsung.command.Command;
import com.samsung.command.strategy.LoginCommand;
import com.samsung.database.entity.Account;
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
