package com.samsung.command;


import com.samsung.di.annotation.CommandScope;

import javax.inject.Inject;
import java.util.ArrayDeque;
import java.util.Deque;

@CommandScope
public final class CommandProcessor {
    private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

    @Inject
    CommandProcessor(CommandRouter firstCommandRouter) {
        commandRouterStack.push(firstCommandRouter);
    }

    public Status process(String input) {
        Result result = commandRouterStack.peek().route(input);
        if (result.status().equals(Status.INPUT_COMPLETED)) {
            commandRouterStack.pop();
            return commandRouterStack.isEmpty() ? Status.INPUT_COMPLETED : Status.HANDLED;
        }

        result.nestedCommandRouter().ifPresent(commandRouterStack::push);
        return result.status();
    }
}
