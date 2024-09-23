package com.samsung.command.strategy;

import java.util.List;

public interface Command {
    boolean handleInput(List<String> input);
}