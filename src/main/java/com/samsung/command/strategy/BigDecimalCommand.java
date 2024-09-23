package com.samsung.command.strategy;

import com.samsung.command.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

/**
 * Abstract {@link Command} that expects a single argument that can be converted to {@link
 * BigDecimal}.
 */
public abstract class BigDecimalCommand extends SingleArgCommand {
    private static final Logger LOGGER = LogManager.getLogger();

    protected BigDecimalCommand() {
        LOGGER.debug("BigDecimalCommand Created");
    }

    @Override
    protected final Result handleArg(String arg) {
        BigDecimal amount = tryParse(arg);
        if (amount == null) {
            LOGGER.info("{} is not a valid number", arg);
        } else if (amount.signum() <= 0) {
            LOGGER.info("amount must be positive");
        } else {
            handleAmount(amount);
        }
        return Result.handled();
    }

    private static BigDecimal tryParse(String arg) {
        try {
            return new BigDecimal(arg);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /** Handles the given (positive) {@code amount} of money. */
    protected abstract void handleAmount(BigDecimal amount);
}
