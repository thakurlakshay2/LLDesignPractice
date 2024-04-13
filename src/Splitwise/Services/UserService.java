package Splitwise.Services;

import Splitwise.Model.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final List<User> allUsers;

    public UserService(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public Optional<User> getUser(String userName){
        return allUsers.stream().filter((user)->{return user.getUserName().equals(userName);}).findFirst();
    }
}
