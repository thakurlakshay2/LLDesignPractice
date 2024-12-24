package Wallet.Strategy;

import java.math.BigDecimal;

public interface TransactionStrategy {
    void processTransaction(String userId, BigDecimal amount);
}
