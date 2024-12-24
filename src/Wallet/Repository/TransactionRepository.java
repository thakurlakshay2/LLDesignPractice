package Wallet.Repository;

import Wallet.Models.Transaction;
import Wallet.Models.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    List<Transaction> findByUserId(String userId);
    List<Transaction> findByAmount(BigDecimal amount);
    List<Transaction> findByTimeStamp(LocalDateTime timestamp);
    List<Transaction> findByType(TransactionType type);
}
