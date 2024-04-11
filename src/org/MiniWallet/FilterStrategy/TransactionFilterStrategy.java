package org.MiniWallet.FilterStrategy;

import org.MiniWallet.model.Transaction;

import java.util.List;

public interface TransactionFilterStrategy {
    List<Transaction> filter(List<Transaction> transactionList);
}
