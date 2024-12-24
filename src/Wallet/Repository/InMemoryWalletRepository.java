package Wallet.Repository;

import Wallet.Models.Wallet;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryWalletRepository implements WalletRepository {
    private Map<String, Wallet> wallets = new HashMap<>();

    @Override
    public Wallet save(Wallet wallet) {
        wallets.put(wallet.getUserId(), wallet);
        return wallet;
    }

    @Override
    public Optional<Wallet> findByUserId(String userId) {
        return Optional.ofNullable(wallets.get(userId));
    }
}
