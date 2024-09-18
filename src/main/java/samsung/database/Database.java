package samsung.database;

import com.samsung.database.entity.Account;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Database {
    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    public Database() {}

    public Account getAccount(String username) {
        return accounts.computeIfAbsent(username, Account::new);
    }
}
