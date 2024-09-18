package com.samsung.command.strategy;

import com.samsung.command.Outputter;
import com.samsung.command.Result;
import com.samsung.command.component.UserCommandsRouter;
import com.samsung.database.Database;
import com.samsung.database.entity.Account;

import javax.inject.Inject;
import java.util.Optional;

public final class LoginCommand extends SingleArgCommand {
    private final Database database;
    private final Outputter outputter;
    private final UserCommandsRouter.Factory userCommandsRouterFactory;
    private final Optional<Account> account;

    @Inject
    public LoginCommand(Database database, Outputter outputter, UserCommandsRouter.Factory userCommandsRouterFactory, Optional<Account> account) {
        this.database = database;
        this.outputter = outputter;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
        this.account = account;
    }

    @Override
    public Result handleArg(String username) {
        if (account.isPresent()) {
            // Ignore "login <foo>" commands if we already have an account
            outputter.output("already login " + account.get().username());
            return Result.handled();
        }
        Account account = database.getAccount(username);
        outputter.output(username + " is logged in with balance: " + account.balance());
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router());
    }
}
