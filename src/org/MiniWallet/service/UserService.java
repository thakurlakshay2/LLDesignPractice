package org.MiniWallet.service;

import org.MiniWallet.model.User;

public interface UserService {
  User registerUser(String username);

  User createWalletForUser(String userId);
}
