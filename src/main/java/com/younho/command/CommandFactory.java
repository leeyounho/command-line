package com.younho.command;

import com.younho.cache.Cache;
import com.younho.command.picocli.Ascii;
import com.younho.command.picocli.Exit;
import com.younho.command.picocli.HelloWorld;
import com.younho.util.ConsoleLogger;

import javax.inject.Inject;

public class CommandFactory {
    @Inject
    public Cache cache;
    @Inject
    public ConsoleLogger console;

    @Inject
    public CommandFactory() {
    }

    public Command createCommand(String commandKey) {
        switch (commandKey) {
            case "ascii":
                return new Ascii();
            case "picohello":
                return new HelloWorld(cache);
            case "exit":
                return new Exit(console);
            default:
                return null; // TODO execute 안되도록 handling 해야함
        }
    }
}
