package com.samsung.command;

import java.util.List;

public interface Command {
    Result handleInput(List<String> input);
}