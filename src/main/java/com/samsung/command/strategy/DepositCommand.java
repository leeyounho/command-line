package com.samsung.command.strategy;

import com.samsung.command.Outputter;
import com.samsung.database.entity.Account;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class DepositCommand extends BigDecimalCommand {
    private final Account account;
    private final Outputter outputter;

    @Inject
    public DepositCommand(Account account, Outputter outputter) {
        super(outputter);
        this.account = account;
        this.outputter = outputter;
    }

    @Override
    public void handleAmount(BigDecimal amount) {
        account.deposit(amount);
        outputter.output(account.username() + " now has: " + account.balance());
    }
}
