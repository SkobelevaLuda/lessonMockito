package org.example.repository;

import org.example.user.User;

import java.util.*;


public class UserRepository {

    private List<User> users = new ArrayList<>();
    private Object Optional;
    private User user;

    public Collection<User> getAllUser() {
        return Collections.unmodifiableCollection(users);
    }

    public String getByLogin(String login) {
        if (!users.contains(login)){
            System.out.println("Логин не найден");
        }
        return Optional <User>;
    }

    public User getByLoginAndPassword(String login, String password) {
        getAllUser().stream().anyMatch(user -> user.equals(user));
        return Optional < User >;
    }

    public void addUser(User user) {
        List.of(user);
    }

}
