package FlipkartRound1.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final String phoneNumber;
    private boolean isActive;
    private List<BankAccount> bankAccounts;
    private BankAccount primaryBankAccount;

    public User(UserBuilder builder){
        this.id= UUID.randomUUID().toString();
        this.name=builder.name;
        this.phoneNumber=builder.phoneNumber;
        this.isActive=true;
        this.bankAccounts=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(bankAccounts);
    }

    public BankAccount getPrimaryBankAccount() {
        return primaryBankAccount;
    }

    public void setPrimaryBankAccount(BankAccount primaryBankAccount) {
        this.primaryBankAccount = primaryBankAccount;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void addBankAccount(BankAccount account) throws Exception {
        if( bankAccounts.isEmpty()){
            primaryBankAccount=account;
        }
       boolean isAlreadyStored= bankAccounts.stream().filter(t->t.getAccountNumber()==account.getAccountNumber()).toList().size()>0;
        if(isAlreadyStored){
            throw new Exception("Bank already stored");
        }
        bankAccounts.add(account);
    }


    public static class UserBuilder{
        private final String name;
        private final String phoneNumber;
        private boolean isActive;

        public UserBuilder(String name, String phoneNumber){
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.isActive = true;
        }

        public UserBuilder setActive(boolean active) {
            this.isActive = active;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
