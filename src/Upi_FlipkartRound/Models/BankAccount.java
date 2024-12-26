package Upi_FlipkartRound.Models;

import java.util.UUID;

public class BankAccount {
    private final String id;
    private final String accountNumber;
    private final Bank bank;
    private double balance;
    private final User owner;

    public BankAccount( String accountNumber, Bank bank, User owner) {
        this.id = UUID.randomUUID().toString();
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }
}
