package org.example.repository;

import org.example.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static List<User> users = new ArrayList<>();


    public static List<User> getAllUsers(){
        return new ArrayList<>();
    }
    public User addUser(User user) {
        users.add(user);
        return (User) users;
    }


    public Optional<User> getByLogin(String login) {

        return users.stream()
                .filter(e-> e.getLogin().equals(login))
                .findAny();
    }

    public static Optional<User> getByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}
