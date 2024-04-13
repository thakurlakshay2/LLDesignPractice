package Splitwise.Model;

public class User {

    private final int userId;
    private final String userName;
    private final String userEmail;
    private  final int phone;

    public User(int userId, String userName, String userEmail, int phone ) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.phone = phone;

    }
    public String getUserName(){
        return userName;
    }
    public String getUserEmail(){
        return userEmail;
    }
    public int getUserPhone(){
        return phone;
    } public int getUserId(){
        return userId;
    }
}
