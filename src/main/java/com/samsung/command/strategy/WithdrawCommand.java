package com.samsung.command.strategy;

import com.samsung.command.Outputter;
import com.samsung.command.qualifier.MaximumWithdrawal;
import com.samsung.command.qualifier.MinimumBalance;
import com.samsung.database.entity.Account;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class WithdrawCommand extends BigDecimalCommand {
    private final Account account;
    private final Outputter outputter;
    private final BigDecimal maximumWithdrawal;
    private final BigDecimal minimumBalance;

    @Inject
    public WithdrawCommand(Outputter outputter, Account account, @MinimumBalance BigDecimal minimumBalance, @MaximumWithdrawal BigDecimal maximumWithdrawal) {
        super(outputter);
        this.account = account;
        this.outputter = outputter;
        this.maximumWithdrawal = maximumWithdrawal;
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void handleAmount(BigDecimal amount) {
        if (amount.compareTo(maximumWithdrawal) > 0) {
            // output error
            return;
        }

        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.compareTo(minimumBalance) < 0) {
            // output error
        } else {
            account.withdraw(amount);
            outputter.output("your new balance is: " + account.balance());
        }
    }
}
