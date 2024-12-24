package FlipkartRound1.Repository;

import FlipkartRound1.Models.BankAccount;
import FlipkartRound1.Models.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(String id);
    User findByPhoneNumber(String phoneNumber);
    List<User> findAll();
    void delete(String id);
    void addBank(String userId, BankAccount addBank) throws Exception;
    void toggleAccount(String userId, String bankAccountId, boolean activeStatus) throws Exception;
    void toggleUser(String userId,boolean active) throws Exception;
}


