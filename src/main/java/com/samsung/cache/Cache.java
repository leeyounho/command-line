package com.samsung.cache;

import com.samsung.cache.entity.Account;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Cache {
    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    public Cache() {}

    public Account getAccount(String username) {
        return accounts.computeIfAbsent(username, Account::new);
    }
}
