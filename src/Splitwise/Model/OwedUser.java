package Splitwise.Model;

public class OwedUser {
   private final User user;
   private Double balance;

    public OwedUser(User user,Double balance) {
        this.user = user;
        this.balance=balance;
    }

    public User getUser(){
        return user;
    }
    public Double getBalance(){
        return balance;
    }
    public void setBalance(Double balance){
        this.balance=balance;
    }
}
