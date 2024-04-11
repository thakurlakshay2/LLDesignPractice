package org.MiniWallet.exceptions;

public class NoUserFound extends RuntimeException{
  public NoUserFound(String userId){
    super("No user found with Id: "+ userId);
  }
}
