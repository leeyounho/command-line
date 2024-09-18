package com.samsung.command.strategy;

import com.samsung.command.Command;
import com.samsung.command.Result;
import com.samsung.database.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public final class LogoutCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Account account;

    @Inject
    public LogoutCommand(Account account) {
        this.account = account;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        LOGGER.info("logged out {}", account.username());
        return Result.inputCompleted();
    }
}
