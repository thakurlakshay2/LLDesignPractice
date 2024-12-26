package Upi_FlipkartRound.Repository.impl;

import Upi_FlipkartRound.Exceptions.DuplicatePhoneNumberException;
import Upi_FlipkartRound.Models.BankAccount;
import Upi_FlipkartRound.Models.User;
import Upi_FlipkartRound.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserRepository  implements UserRepository {
    private final Map<String,User> users=new ConcurrentHashMap<>();
    private final Map<String,User> phoneNumberIndex= new ConcurrentHashMap<>();

    @Override
    public User save(User user) {
        if(phoneNumberIndex.containsKey(user.getPhoneNumber())
                && !phoneNumberIndex.get((user.getPhoneNumber())).getId().equals(user.getId())){
           throw new DuplicatePhoneNumberException("Phone Number already exists");
        }
        users.put(user.getId(),user);
        phoneNumberIndex.put(user.getPhoneNumber(),user);
        return user;
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return  phoneNumberIndex.get(phoneNumber);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void delete(String id) {

    }

    public void addBank(String userId,BankAccount bankAccount) throws Exception {
        if(bankAccount.getOwner().equals(userId)){

        }
        User user=this.findById(userId);
        user.addBankAccount(bankAccount);
    }
    public void toggleAccount(String userId, String bankAccountId, boolean activeStatus) throws  Exception{
        User user=this.findById(userId);
        List<BankAccount> allAccount= user.getBankAccounts();
        BankAccount b= allAccount.stream().filter(t->t.getBank().getId().equals(bankAccountId)).toList().get(0);

        b.getBank().setServerActive(activeStatus);
    }

    public void toggleUser(String userId,boolean active) throws  Exception{
        User user=this.findById(userId);
        user.setActive(active);
    }
}
