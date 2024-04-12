package org.MiniWallet.datastore;

import org.MiniWallet.exceptions.NoWalletFoundException;
import org.MiniWallet.exceptions.WalletAlreadyExist;
import org.MiniWallet.model.Wallet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WalletData {
   public Map<String, Wallet> walletIdToWallet = new HashMap();
  public Map<String, String> userIdToWalletId = new HashMap<>();

  public Wallet getWalletByUserId(String userId){
    String walletId = userIdToWalletId.get(userId);
    if(Objects.isNull(walletId)) throw new NoWalletFoundException("No wallet found corresponding to user id: " + userId);
    Wallet reqWallet = walletIdToWallet.get(walletId);
    if(Objects.isNull(reqWallet)) throw new NoWalletFoundException("No wallet found corresponding to user id: " + userId);
    return reqWallet;
  }
  public void getWalletIdToWallet(String  walletId,Wallet wallet){
      if(walletIdToWallet.containsKey(walletId)){
        throw new WalletAlreadyExist();
      }
      walletIdToWallet.put(walletId,wallet);
  }

  public void getUserIdToWalletId(String  userId,String walletId){
    if(userIdToWalletId.containsKey(walletId)){
      throw new WalletAlreadyExist();
    }
    userIdToWalletId.put(userId,walletId);
  }
}
