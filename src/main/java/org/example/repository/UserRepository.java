package org.example.repository;

import org.example.user.User;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UserRepository {

    private List<User> users = new ArrayList<>();


    public Collection<User> getAllUsers(){
        return users;
    }
    public void addUser(User user) {
        users.add(user);
    }


    public Optional<User> getByLogin(String login) {

        return users.stream()
                .filter(e-> e.getLogin().equals(login))
                .findAny();
    }

    public Optional<User> getByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}
