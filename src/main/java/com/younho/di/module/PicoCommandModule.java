package com.younho.di.module;

import com.younho.command.PicoCommandHandler;
import com.younho.command.picocli.Ascii;
import com.younho.command.picocli.Exit;
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
    abstract PicoCommandHandler ascii(Ascii command);

    @Binds
    @IntoMap
    @StringKey("picohello")
    abstract PicoCommandHandler picoHelloWorld(PicoHelloWorld command);

    @Binds
    @IntoMap
    @StringKey("exit")
    abstract PicoCommandHandler exit(Exit command);
}
