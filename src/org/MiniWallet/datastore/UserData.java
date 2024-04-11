package org.MiniWallet.datastore;

import lombok.Getter;
import org.MiniWallet.exceptions.NoUserFound;
import org.MiniWallet.exceptions.UserAlreadyExist;
import org.MiniWallet.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class UserData {
  Map<String, User> userIdToUser = new HashMap<>();

  public User getUserById(String id){
    User user = userIdToUser.get(id);
    if(Objects.isNull(id)) throw new NoUserFound(id);
    return user;
  }

  public void putUserIdToUser(String userId,User user){
    if(userIdToUser.containsKey(userId)){
      throw new UserAlreadyExist("User already exist");
    }
    userIdToUser.put(userId,user);
  }
}
