package com.samsung.cache;

import com.samsung.cache.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Cache {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    public Cache() {
        LOGGER.debug("Initializing Cache");
    }

    public Account getAccount(String username) {
        return accounts.computeIfAbsent(username, Account::new);
    }
}
