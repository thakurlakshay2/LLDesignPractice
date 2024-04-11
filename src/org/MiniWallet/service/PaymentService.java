package org.MiniWallet.service;

import org.MiniWallet.FilterStrategy.TransactionFilterStrategy;
import org.MiniWallet.SortStrategy.TransactionSortStrategy;
import org.MiniWallet.enums.Ordering;
import org.MiniWallet.enums.PaymentMode;
import org.MiniWallet.model.Transaction;

import java.util.List;

public interface PaymentService {
  Transaction payment(String payer, String payee, Double amount, PaymentMode paymentMode);

  Transaction topUpWallet(String userId, Double amount, PaymentMode paymentMode);

    List<Transaction> getTransaction(String userId, TransactionSortStrategy transactionSortStrategy, Ordering ordering,
        List<TransactionFilterStrategy> transactionFilterStrategies);


}
