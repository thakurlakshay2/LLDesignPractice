package Wallet.Service;

import Wallet.Exceptions.InsufficientBalanceException;
import Wallet.Exceptions.NotFoundException;
import Wallet.Models.Transaction;
import Wallet.Models.TransactionType;
import Wallet.Models.User;
import Wallet.Models.Wallet;
import Wallet.Repository.TransactionRepository;
import Wallet.Repository.UserRepository;
import Wallet.Repository.WalletRepository;
import Wallet.Strategy.TransactionFilterStrategy;
import Wallet.Strategy.TransactionStrategy;
import Wallet.Strategy.TransactionStrategyFactory;
import Wallet.Strategy.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class WalletService {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionStrategyFactory transactionStrategyFactory;

    public WalletService(UserRepository userRepository, WalletRepository walletRepository, TransactionRepository transactionRepository, TransactionStrategyFactory transactionStrategyFactory) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
        this.transactionStrategyFactory = transactionStrategyFactory;
    }

    public void registerUser(User user){
        userRepository.save(user);
         Wallet wallet=new Wallet(user.getUserId(), BigDecimal.ZERO);
         walletRepository.save(wallet);
    }

    public void loadMoney(String userId,BigDecimal amount, TransactionTypeEnum source){
        if(amount.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("Amount Must be greater than 0");
        }

        TransactionStrategy strategy=transactionStrategyFactory.getStrategy(source);
        strategy.processTransaction(userId,amount);
    }
    public void transferMoney(String fromUserId, String toUserId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        Wallet senderWallet = walletRepository.findByUserId(fromUserId)
                .orElseThrow(() -> new NotFoundException("Sender wallet not found"));

        Wallet receiverWallet = walletRepository.findByUserId(toUserId)
                .orElseThrow(() -> new NotFoundException("Receiver wallet not found"));

        if (senderWallet.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        senderWallet.updateBalance(amount , TransactionType.DEBIT);
        receiverWallet.updateBalance(amount , TransactionType.CREDIT);
        // Create and process transaction
        Transaction transaction = new Transaction(fromUserId, toUserId, amount);
        transactionRepository.save(transaction);


//        processTransaction(transaction);
    }

    public BigDecimal getBalance(String userId) {
        return walletRepository.findByUserId(userId)
                .map(Wallet::getBalance)
                .orElseThrow(() -> new NotFoundException("Wallet not found"));
    }

    public List<Transaction> getTransactionHistory(
            String userId,
            Optional<BigDecimal> amount,
            Optional<LocalDateTime> timestamp,
            Optional<TransactionType> type) {

        // Using Strategy Pattern for filtering
        TransactionFilterStrategy filterStrategy = new TransactionFilterStrategy();
        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        return filterStrategy.apply(transactions, amount, timestamp, type);
    }
}
