package com.samsung.di.module.command;

import com.samsung.command.strategy.ASCIIArt;
import com.samsung.command.strategy.CommandHandler;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class ASCIIArtModule {
    @Binds
    @IntoMap
    @StringKey("ascii")
    abstract CommandHandler ascii(ASCIIArt command);
}
