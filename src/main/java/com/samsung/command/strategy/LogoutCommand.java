package com.samsung.command.strategy;

import com.samsung.command.Command;
import com.samsung.command.Outputter;
import com.samsung.command.Result;
import com.samsung.database.entity.Account;

import javax.inject.Inject;
import java.util.List;

public final class LogoutCommand implements Command {
    private final Outputter outputter;
    private final Account account;

    @Inject
    public LogoutCommand(Outputter outputter, Account account) {
        this.outputter = outputter;
        this.account = account;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        outputter.output("logged out " + account.username());
        return Result.inputCompleted();
    }
}
