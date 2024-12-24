package Wallet.Strategy;

import Wallet.Exceptions.NotFoundException;
import Wallet.Exceptions.PaymentProcessingException;
import Wallet.Models.Transaction;
import Wallet.Models.TransactionStatus;
import Wallet.Models.TransactionType;
import Wallet.Models.Wallet;
import Wallet.Repository.TransactionRepository;
import Wallet.Repository.WalletRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DebitCardStrategy implements  TransactionStrategy{
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    // Constructor injection required
    public DebitCardStrategy(WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void processTransaction(String userId, BigDecimal amount) {
        // 1. Find user's wallet
        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Wallet not found"));

        // 2. Create transaction record
        Transaction transaction = new Transaction(
                "DEBIT_CARD",
                userId,
                amount,
                LocalDateTime.now(),
                TransactionStatus.PENDING,
                TransactionType.CREDIT
        );

        try {
            // 3. Process payment (mock external service call)
            processDebitCardPayment(amount);

            // 4. Update wallet balance
            wallet.updateBalance(amount, TransactionType.CREDIT);
            walletRepository.save(wallet);

            // 5. Update transaction status
            transaction.setStatus(TransactionStatus.SUCCESS);

        } catch (Exception e) {
            transaction.setStatus(TransactionStatus.FAILED);
            throw new PaymentProcessingException("Debit card payment failed: " + e.getMessage());
        } finally {
            // 6. Save transaction record
            transactionRepository.save(transaction);
        }
    }

    private void processDebitCardPayment(BigDecimal amount) {
        // Mock external payment gateway call
        if (amount.compareTo(new BigDecimal("10000")) > 0) {
            throw new PaymentProcessingException("Amount exceeds debit card limit");
        }
        // Simulate processing delay
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
