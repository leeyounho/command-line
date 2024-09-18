package com.samsung.command.qualifier;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/** Qualifier for the minimum balance an account may have. */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface MinimumBalance {}