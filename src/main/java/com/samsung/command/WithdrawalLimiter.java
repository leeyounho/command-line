package com.samsung.command;

import com.samsung.command.qualifier.MaximumWithdrawal;

import javax.inject.Inject;
import java.math.BigDecimal;

final class WithdrawalLimiter {
    private BigDecimal remainingWithdrawalLimit;

    @Inject
    WithdrawalLimiter(@MaximumWithdrawal BigDecimal maximumWithdrawal) {
        this.remainingWithdrawalLimit = maximumWithdrawal;
    }

    void recordDeposit(BigDecimal amount) {

    }

    void recordWithdrawal(BigDecimal amount) {

    }
}
