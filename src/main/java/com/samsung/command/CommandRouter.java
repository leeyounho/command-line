package com.samsung.command;

import com.samsung.command.strategy.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class CommandRouter {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Map<String, Command> commands;

    @Inject
    public CommandRouter(Map<String, Command> commands) {
        LOGGER.debug("Initializing CommandRouter");

        // Command Interface 하위 Command를 Map에 넣음
        this.commands = commands;
    }

    public boolean route(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return false;
        }

        String commandKey = splitInput.get(0);
        Command command = commands.get(commandKey); // Map 에 있는 Command 를 key 로 호출
        if (command == null) {
            return false;
        }

        List<String> args = splitInput.subList(1, splitInput.size());
        return command.handleInput(args);
    }

    // Split on whitespace
    private List<String> split(String input) {
        return Arrays.asList(input.trim().split("\\s+"));
    }
}
