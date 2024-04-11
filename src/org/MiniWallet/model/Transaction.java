package org.MiniWallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.MiniWallet.enums.PaymentMode;
import org.MiniWallet.enums.TransactionType;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
public class Transaction {
  String transactionId;
  String payer;
  String payee;
  double amount;
  TransactionType transactionType;
  Timestamp timestamp;
  PaymentMode paymentMode;

  public Transaction(String transactionId, String payer, String payee, double amount, TransactionType transactionType, Timestamp timestamp, PaymentMode paymentMode) {
    this.transactionId = transactionId;
    this.payer = payer;
    this.payee = payee;
    this.amount = amount;
    this.transactionType = transactionType;
    this.timestamp = timestamp;
    this.paymentMode = paymentMode;
  }
}
