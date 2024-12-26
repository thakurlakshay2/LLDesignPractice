package Upi_FlipkartRound.Strategy;

import Upi_FlipkartRound.Exceptions.PaymentException;
import Upi_FlipkartRound.Models.Transaction;
import Upi_FlipkartRound.Models.TransactionStatus;
import Upi_FlipkartRound.Repository.TransactionRepository;
import Upi_FlipkartRound.Repository.UserRepository;

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
