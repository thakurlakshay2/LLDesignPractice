package Wallet;

import Wallet.Exceptions.InsufficientBalanceException;
import Wallet.Models.Transaction;
import Wallet.Models.User;
import Wallet.Repository.*;
import Wallet.Service.WalletService;
import Wallet.Strategy.TransactionStrategyFactory;
import Wallet.Strategy.TransactionTypeEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        WalletRepository walletRepository = new InMemoryWalletRepository();
        TransactionRepository transactionRepository = new InMemoryTransactionRepository();

        TransactionStrategyFactory transactionStrategyFactory = new TransactionStrategyFactory(walletRepository,transactionRepository);

        // Create wallet service
        WalletService walletService = new WalletService(
                userRepository,
                walletRepository,
                transactionRepository,
                transactionStrategyFactory
        );

        try {
            // 1. Create users
            System.out.println("Creating users...");
            User user1 = new User( "John Doe", "john@example.com");
            User user2 = new User( "Jane Smith", "jane@example.com");

            walletService.registerUser(user1);
            walletService.registerUser(user2);
            System.out.println("Users created successfully!");

            // 2. Load money into wallets
            System.out.println("\nLoading money into wallets...");
            walletService.loadMoney(user1.getUserId(), new BigDecimal("1000.00"), TransactionTypeEnum.CREDIT_CARD);
            walletService.loadMoney(user2.getUserId(), new BigDecimal("500.00"), TransactionTypeEnum.UPI);

            System.out.println("John's balance: $" + walletService.getBalance(user1.getUserId()));
            System.out.println("Jane's balance: $" + walletService.getBalance(user2.getUserId()));

            // 3. Perform wallet to wallet transfer
            System.out.println("\nPerforming transfers...");
            walletService.transferMoney(user1.getUserId(), user2.getUserId(), new BigDecimal("300.00"));
            System.out.println("Transfer completed!");

            System.out.println("John's new balance: $" + walletService.getBalance(user1.getUserId()));
            System.out.println("Jane's new balance: $" + walletService.getBalance(user2.getUserId()));

            // 4. Get transaction history with different filters
            System.out.println("\nFetching transaction history...");

            // Get all transactions for user1
            List<Transaction> allTransactions = walletService.getTransactionHistory(
                    user1.getUserId(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()
            );
            System.out.println("All transactions for John: " + allTransactions.size());

            // Get transactions by amount
            List<Transaction> amountFilteredTransactions = walletService.getTransactionHistory(
                    user1.getUserId(),
                    Optional.of(new BigDecimal("300.00")),
                    Optional.empty(),
                    Optional.empty()
            );
            System.out.println("Transactions with amount $300: " + amountFilteredTransactions.size());

            // 5. Demonstrate error handling
            System.out.println("\nTesting error handling...");

            try {
                // Try to transfer more than available balance
                walletService.transferMoney(user1.getUserId(), user2.getUserId(), new BigDecimal("1000.00"));
            } catch (InsufficientBalanceException e) {
                System.out.println("Expected error caught: " + e.getMessage());
            }

            try {
                // Try to load negative amount
                walletService.loadMoney(user1.getUserId(), new BigDecimal("-100.00"), TransactionTypeEnum.CREDIT_CARD);
            } catch (IllegalArgumentException e) {
                System.out.println("Expected error caught: " + e.getMessage());
            }

            // 6. Load money using different payment methods
            System.out.println("\nTesting different payment methods...");
            walletService.loadMoney(user1.getUserId(), new BigDecimal("200.00"), TransactionTypeEnum.DEBIT_CARD);
            walletService.loadMoney(user2.getUserId(), new BigDecimal("300.00"), TransactionTypeEnum.UPI);

            System.out.println("Final balances:");
            System.out.println("John's balance: $" + walletService.getBalance(user1.getUserId()));
            System.out.println("Jane's balance: $" + walletService.getBalance(user2.getUserId()));

        } catch (Exception e) {
            System.err.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
