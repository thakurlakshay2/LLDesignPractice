package Wallet.Strategy;

import Wallet.Repository.TransactionRepository;
import Wallet.Repository.WalletRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TransactionStrategyFactory {
    private final Map<TransactionTypeEnum,TransactionStrategy> strategies;

    public TransactionStrategyFactory(WalletRepository walletRepository,TransactionRepository transactionRepository) {
        this.strategies = new HashMap<>();
        strategies.put(TransactionTypeEnum.CREDIT_CARD,new CreditCardStrategy(walletRepository,transactionRepository));
        strategies.put(TransactionTypeEnum.DEBIT_CARD,new DebitCardStrategy(walletRepository,transactionRepository));
        strategies.put(TransactionTypeEnum.UPI,new UpiStrategy(walletRepository,transactionRepository));
    }
    public TransactionStrategy getStrategy(TransactionTypeEnum source){
        return Optional.ofNullable(strategies.get(source
        )).orElseThrow(()-> new IllegalArgumentException("Invalid Input Source"));
    }
}
