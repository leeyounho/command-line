package com.samsung.command.strategy;

import java.util.List;

/** Abstract command that accepts a single argument. */
public abstract class SingleArgCommand implements Command {

    @Override
    public final boolean handleInput(List<String> input) {
        return input.size() == 1 && handleArg(input.get(0));
    }

    /** Handles the single argument to the command. */
    protected abstract boolean handleArg(String arg);
}
