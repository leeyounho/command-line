package com.samsung.command.module;

import com.samsung.command.qualifier.MaximumWithdrawal;
import com.samsung.command.qualifier.MinimumBalance;
import dagger.Module;
import dagger.Provides;

import java.math.BigDecimal;

@Module
public interface AmountsModule {
    @Provides
    @MinimumBalance
    public static BigDecimal minimumBalance() {
        return BigDecimal.ZERO;
    }

    @Provides
    @MaximumWithdrawal
    public static BigDecimal maximumWithdrawal() {
        return new BigDecimal(1000);
    }
}
