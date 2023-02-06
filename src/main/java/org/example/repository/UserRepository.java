package org.example.repository;

import org.example.user.User;

import java.util.*;


public class UserRepository {

    private Map<Integer, User> allUsers = new HashMap<>();

    public List<User> getAllUser(){
        return new ArrayList<User>(allUsers.values());
    }
    public User getByLogin(String login){
        if(this.allUsers.stream().filter(user -> login.equals(User.getLogin()))
                .findFirst());
        return Optional<User>;

    }


    public List<User> addUser( User user){
         List.of().add(user);
         return (List<User>) user;
    }
}
