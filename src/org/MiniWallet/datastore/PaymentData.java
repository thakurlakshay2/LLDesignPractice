package org.MiniWallet.datastore;

import lombok.Getter;
import org.MiniWallet.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class PaymentData {
  Map<String, List<Transaction>> userIdToTransactionList = new HashMap<>();


  public List<Transaction> getUserIdToTransactionList(String userId){
   return  userIdToTransactionList.getOrDefault(userId,new ArrayList<Transaction>());
  }

  public void putUserIdToTransactionList(String userId,List<Transaction> transactionList){
    userIdToTransactionList.put(userId,transactionList);
  }
}
