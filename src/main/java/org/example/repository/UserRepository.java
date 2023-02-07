package org.example.repository;

import org.example.user.User;

import java.util.*;


public class UserRepository {

    private List<User> users = new ArrayList<>();
    private Object Optional;

    public Collection<User> getAllUser() {
        return Collections.unmodifiableCollection(users);
    }

    public Optional<User> getByLogin(String login) {
        getAllUser()
                .stream()
                .filter(user -> login.equals(user.getLogin()));
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
