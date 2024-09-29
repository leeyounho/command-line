package com.younho.command;

import com.google.common.base.Splitter;
import com.younho.util.ConsoleLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public final class CommandRouter {
    private static final Logger LOGGER = LogManager.getLogger(CommandRouter.class);
    private final Map<String, PicoCommandHandler> commands;
    private final ConsoleLogger console;

    @Inject
    public CommandRouter(Map<String, PicoCommandHandler> commands, ConsoleLogger console) {
        LOGGER.debug("Initializing CommandRouter");

        // Command Interface 하위 Command를 모두 Map에 넣음
        this.commands = commands;
        this.console = console;
    }

    public int route(String input) {
        List<String> result = Splitter.on(" ").trimResults().splitToList(input);
        if (result.isEmpty()) {
            return -1;
        }

        String commandKey = result.get(0);
        PicoCommandHandler picoCommandHandler = commands.get(commandKey); // Map 에 있는 Command 를 key 로 호출
        if (picoCommandHandler == null) {
            console.info(commandKey + " is not a valid command");
            return -1;
        }

        List<String> args = result.subList(1, result.size());
        return picoCommandHandler.handleArgs(args.toArray(new String[0]));
    }
}
