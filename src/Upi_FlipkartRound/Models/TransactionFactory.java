package Upi_FlipkartRound.Models;

public interface TransactionFactory {
    Transaction createTransaction(String type, User sender, User receiver, double amount);
}
