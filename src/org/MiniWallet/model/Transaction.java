package org.MiniWallet.model;

import org.MiniWallet.enums.PaymentMode;
import org.MiniWallet.enums.TransactionType;

import java.sql.Timestamp;

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

  public Timestamp getTimestamp(){
    return timestamp;
  }

  public double getAmount(){
    return amount;
  }

  public String getPayee(){
    return payee;
  }

  public String getPayer(){
    return payer;
  }

  public TransactionType getTransactionType(){
    return transactionType;
  }
}
