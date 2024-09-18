package samsung.command.qualifier;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Qualifier for the maximum amount that can be withdrawn from an account in a single transaction.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface MaximumWithdrawal {}
