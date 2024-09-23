package com.samsung.command.strategy;

import com.samsung.command.Result;

import java.util.List;

public interface Command {
    Result handleInput(List<String> input);
}