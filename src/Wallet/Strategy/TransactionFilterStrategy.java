package Wallet.Strategy;

import Wallet.Models.Transaction;
import Wallet.Models.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TransactionFilterStrategy {
    public List<Transaction> apply(
            List<Transaction> transactions,
            Optional<BigDecimal> amount,
            Optional<LocalDateTime> timestamp,
            Optional<TransactionType> type) {

        return transactions.stream()
                .filter(t -> amount.map(a -> t.getAmount().equals(a)).orElse(true))
                .filter(t -> timestamp.map(ts -> t.getTimeStamp().equals(ts)).orElse(true))
                .filter(t -> type.map(ty -> t.getType().equals(ty)).orElse(true)).toList();
    }
}
