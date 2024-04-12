package org.MiniWallet.model;


public class Wallet {
  String walletId;
  Double balance;
//  List<Transaction> transactionList;

  public Wallet(String walletId, Double balance) {
    this.walletId = walletId;
    this.balance = balance;
  }
  public double getBalance(){
    return this.balance;
  }

  public void setBalance(Double balance){

    this.balance=balance;
  }
}
