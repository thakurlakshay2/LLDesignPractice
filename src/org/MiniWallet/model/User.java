package org.MiniWallet.model;


public class User {
  String userId;
  String name;

  // for simplicity avoiding KYC details

  public User(String userId, String name) {
    this.userId = userId;
    this.name = name;
  }
}
