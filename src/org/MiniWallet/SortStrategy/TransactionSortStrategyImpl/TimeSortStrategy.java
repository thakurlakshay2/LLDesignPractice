package org.MiniWallet.SortStrategy.TransactionSortStrategyImpl;

import org.MiniWallet.SortStrategy.TransactionSortStrategy;
import org.MiniWallet.enums.Ordering;
import org.MiniWallet.model.Transaction;


import java.util.List;

public class TimeSortStrategy implements TransactionSortStrategy {
    @Override
    public void sort(List<Transaction> transactions, Ordering ordering) {
        if(ordering == Ordering.ASC){
            transactions.sort((t1, t2) -> t1.getTimestamp().compareTo(t2.getTimestamp()));
        } else {
            transactions.sort((t1, t2) -> -1 * t1.getTimestamp().compareTo(t2.getTimestamp()));
        }

    }
}