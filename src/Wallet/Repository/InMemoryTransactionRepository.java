package Wallet.Repository;

import Wallet.Models.Transaction;
import Wallet.Models.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactionRepository implements TransactionRepository{
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public Transaction save(Transaction transaction) {
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> findByUserId(String userId) {
        return transactions.stream()
                .filter(t -> t.getFromUserId().equals(userId) || t.getToUserId().equals(userId))
                .toList();
    }

    @Override
    public List<Transaction> findByAmount(BigDecimal amount) {
        return transactions.stream()
                .filter(t -> t.getAmount().equals(amount))
                .toList();
    }


    @Override
    public List<Transaction> findByTimeStamp(LocalDateTime timestamp) {
        return transactions.stream()
                .filter(t -> t.getTimeStamp().equals(timestamp))
                .toList();
    }

    @Override
    public List<Transaction> findByType(TransactionType type) {
        return transactions.stream()
                .filter(t -> t.getType().equals(type))
                .toList();
    }
}
