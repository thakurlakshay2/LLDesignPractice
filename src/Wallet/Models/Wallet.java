package Wallet.Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Wallet {
    private String walletId;
    private String userId;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Wallet( String userId, BigDecimal balance) {
        this.walletId = UUID.randomUUID().toString();
        this.userId = userId;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getWalletId() {
        return walletId;
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void updateBalance(BigDecimal amount, TransactionType type){
        if(type== TransactionType.CREDIT){
            this.balance=this.balance.add(amount);
        }else{
            this.balance=this.balance.subtract(amount);
        }
    }
}
