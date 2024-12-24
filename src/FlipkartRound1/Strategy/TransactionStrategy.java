package FlipkartRound1.Strategy;

import FlipkartRound1.Models.Transaction;
import FlipkartRound1.Models.TransactionStatus;

import java.util.concurrent.CompletableFuture;

public interface TransactionStrategy {
    CompletableFuture<TransactionStatus> process(Transaction transaction);
}
