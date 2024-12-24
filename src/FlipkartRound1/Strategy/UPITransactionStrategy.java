package FlipkartRound1.Strategy;

import FlipkartRound1.Exceptions.PaymentException;
import FlipkartRound1.Models.Transaction;
import FlipkartRound1.Models.TransactionStatus;
import FlipkartRound1.Repository.TransactionRepository;
import FlipkartRound1.Repository.UserRepository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class UPITransactionStrategy implements TransactionStrategy{
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public UPITransactionStrategy(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public CompletableFuture<TransactionStatus> process(Transaction transaction) {
        return CompletableFuture.supplyAsync(()->{
            try{
                validateTransaction(transaction);
                processWithRetry(transaction);
                return TransactionStatus.SUCCESS;
            }catch(Exception e){
                transaction.setStatus(TransactionStatus.FAILED);
                transactionRepository.save(transaction);
                throw new CompletionException(e);
            }
        });
    }

    private void validateTransaction(Transaction transaction) throws PaymentException {

        throw new PaymentException("Not able to validate Transaction");
    }

    private void processWithRetry(Transaction transaction) throws PaymentException{
        throw new PaymentException("Not able to retry Transaction");
    }
}
