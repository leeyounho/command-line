package com.younho.command;

import com.younho.cache.Cache;
import com.younho.command.picocli.HelloWorld;

import javax.inject.Inject;

public class CommandFactory {
    @Inject public Cache cache;

    @Inject
    public CommandFactory() {
    }

    public Command createCommand(String commandKey) {
        if (commandKey.equals("picohello")) {
            return new HelloWorld(cache);
        }
        return null;
    }
}
