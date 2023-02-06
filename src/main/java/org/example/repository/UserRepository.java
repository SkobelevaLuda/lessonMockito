package org.example.repository;

import org.example.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private Map<Integer, User> allUsers = new HashMap<>();

    public List<User> getAllUser(){
        return new ArrayList<User>(allUsers.values());
    }
}
