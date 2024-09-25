package com.samsung.command;

import com.google.common.base.Splitter;
import com.samsung.command.strategy.CommandHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public final class CommandRouter {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Map<String, CommandHandler> commands;

    @Inject
    public CommandRouter(Map<String, CommandHandler> commands) {
        LOGGER.debug("Initializing CommandRouter");

        // Command Interface 하위 Command를 Map에 넣음
        this.commands = commands;
    }

    public int route(String input) {
        List<String> result = Splitter.on(" ").trimResults().splitToList(input);
        if (result.isEmpty()) {
            return -1;
        }

        String commandKey = result.get(0);
        CommandHandler commandHandler = commands.get(commandKey); // Map 에 있는 Command 를 key 로 호출
        if (commandHandler == null) {
            LOGGER.error("{} is not a valid command", commandKey);
            return -1;
        }

        List<String> args = result.subList(1, result.size());
        return commandHandler.handleArgs(args.toArray(new String[0]));
    }
}
