package com.example.assingment10;

import java.util.ArrayList;

public class UserStorage {
    private static UserStorage instance;
    private ArrayList<User> users;
    private UserStorage() {
        users = new ArrayList<>();
    }
    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public void addUser(User user) {
        users.add(user);
    }
}
