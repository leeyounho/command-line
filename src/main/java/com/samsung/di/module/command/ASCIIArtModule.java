package com.samsung.di.module.command;

import com.samsung.command.ASCIIArt;
import com.samsung.command.CommandHandler;
import com.samsung.command.Test;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import picocli.CommandLine;

@Module
public abstract class ASCIIArtModule {
    @Binds
    @IntoMap
    @StringKey("ascii")
    abstract CommandHandler ascii(ASCIIArt command);


    @Binds
    @IntoMap
    @StringKey("test")
    abstract CommandLine test(Test command);
    // TODO CommandLIne을 return하게 하면 좋을 듯. 그러면 new CommandLine(new Test()) 를 가지고 있을 수 있으니..
    //  처음에 COmmandRouter가 가지는 command 를 CommandLine으로해야겠다
}
