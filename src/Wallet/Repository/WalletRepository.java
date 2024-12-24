package Wallet.Repository;

import Wallet.Models.Wallet;

import java.util.Optional;

public interface WalletRepository {
    Wallet save(Wallet user);
    Optional<Wallet> findByUserId(String userId);
}
