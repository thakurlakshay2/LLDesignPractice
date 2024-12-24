package Wallet.Models;

import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private String phone;

    public User(String name, String email) {
        this.userId=UUID.randomUUID().toString();
        this.name = name;
        this.phone = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
