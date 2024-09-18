package com.samsung.command.strategy;

import com.samsung.command.Result;
import com.samsung.command.component.UserCommandsRouter;
import com.samsung.database.Database;
import com.samsung.database.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.Optional;

public final class LoginCommand extends SingleArgCommand {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Database database;
    private final UserCommandsRouter.Factory userCommandsRouterFactory;
    private final Optional<Account> account;

    @Inject
    public LoginCommand(Database database, UserCommandsRouter.Factory userCommandsRouterFactory, Optional<Account> account) {
        this.database = database;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
        this.account = account;
    }

    @Override
    public Result handleArg(String username) {
        if (account.isPresent()) {
            // Ignore "login <foo>" commands if we already have an account
            LOGGER.info("already login {}", account.get().username());
            return Result.handled();
        }
        Account account = database.getAccount(username);
        LOGGER.info("{} is logged in with balance: {}", username, account.balance());
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router());
    }
}
