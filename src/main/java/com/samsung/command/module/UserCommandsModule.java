package com.samsung.command.module;

import com.samsung.command.Command;
import com.samsung.command.strategy.DepositCommand;
import com.samsung.command.strategy.LogoutCommand;
import com.samsung.command.strategy.WithdrawCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract Command depositCommand(DepositCommand command);


    @Binds
    @IntoMap
    @StringKey("withdraw")
    abstract Command withdrawCommand(WithdrawCommand command);

    @Binds
    @IntoMap
    @StringKey("logout")
    abstract Command logout(LogoutCommand command);
}
