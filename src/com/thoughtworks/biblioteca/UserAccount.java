//user Account to store all users and authenticate
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class UserAccount {

    private ArrayList<User> users;

    public UserAccount(ArrayList<User> users) {
        this.users = users;
    }

    public User authenticateUser(String userName, String password) {
        User userToAuthenticate = new User(userName, password, User.type.GUEST, "user1", "user1@gmail.com", "9999999999");
        for(User user : users) {
            if(user.authenticate(userToAuthenticate))
                return user;
        }
        return userToAuthenticate;
    }
}