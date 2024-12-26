package Upi_FlipkartRound.Strategy;

import Upi_FlipkartRound.Models.Transaction;
import Upi_FlipkartRound.Models.TransactionStatus;

import java.util.concurrent.CompletableFuture;

public interface TransactionStrategy {
    CompletableFuture<TransactionStatus> process(Transaction transaction);
}
