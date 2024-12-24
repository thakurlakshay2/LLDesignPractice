package Wallet.Repository;

import Wallet.Models.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(String userId);
}
