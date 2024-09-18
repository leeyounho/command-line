package com.samsung.command.strategy;

import com.samsung.database.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class DepositCommand extends BigDecimalCommand {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Account account;

    @Inject
    public DepositCommand(Account account) {
        super();
        this.account = account;
    }

    @Override
    public void handleAmount(BigDecimal amount) {
        account.deposit(amount);
        LOGGER.info("{} now has: {}",account.username(), account.balance());
    }
}
