package org.MiniWallet.SortStrategy;

import org.MiniWallet.enums.Ordering;
import org.MiniWallet.model.Transaction;

import java.util.List;

public interface TransactionSortStrategy {
  void sort(List<Transaction> transactions, Ordering ordering);
}
