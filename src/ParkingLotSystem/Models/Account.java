package ParkingLotSystem.Models;

public class Account {
    private final String userName;
    private final String password;
    private final AccountStatus accountStatus;

    public Account(String userName, String password, AccountStatus accountStatus) {
        this.userName = userName;
        this.password = password;
        this.accountStatus = accountStatus;
    }
}
