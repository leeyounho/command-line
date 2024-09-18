package samsung.database.entity;

import java.math.BigDecimal;

public final class Account {
    private final String username;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(String username) {
        this.username = username;
    }

    public String username() {
        return username;
    }

    public BigDecimal balance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
}
