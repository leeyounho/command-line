package com.younho.di.module.command;

import com.younho.command.PicoCommandHandler;
import com.younho.command.picocli.ASCIIArt;
import com.younho.command.picocli.PicoHelloWorld;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class PicoCommandModule {
    @Binds
    @IntoMap
    @StringKey("ascii")
    abstract PicoCommandHandler ascii(ASCIIArt command);

    @Binds
    @IntoMap
    @StringKey("picohello")
    abstract PicoCommandHandler picoHelloWorld(PicoHelloWorld command);
}
