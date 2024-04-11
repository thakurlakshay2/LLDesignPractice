package org.MiniWallet.service.impl;

import org.MiniWallet.datastore.UserData;
import org.MiniWallet.exceptions.NoUserFound;
import org.MiniWallet.exceptions.UserAlreadyExist;
import org.MiniWallet.model.User;
import org.MiniWallet.service.UserService;
import org.MiniWallet.service.WalletServiceInternal;

import java.util.Objects;

public class UserServiceImpl implements UserService {

  private UserData userData;

  private WalletServiceInternal walletService;

  public UserServiceImpl(UserData userData, WalletServiceInternal walletService){
    this.userData = userData;
    this.walletService = walletService;
  }

  @Override
  public User registerUser(String username) {
    System.out.println("Registering user " + username);
    User newUser = new User(username, username);
    User user = userData.getUserById(username);
    if(Objects.nonNull(user)){
      throw new UserAlreadyExist("User already exist");
    }
    userData.putUserIdToUser(username, newUser);
    System.out.println("User " + username + " is registered");
    return newUser;
  }
  @Override
  public User createWalletForUser(String userId){
        User user= userData.getUserById(userId);
        if(Objects.isNull(user)){
          throw new NoUserFound(userId);
        }
        walletService.createWallet(userId);
        System.out.println("User " + userId + " walled is created");
        return user;
  }
}
