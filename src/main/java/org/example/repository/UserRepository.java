package org.example.repository;

import org.example.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class UserRepository {

    private static List<User> users = new ArrayList<>();
    private boolean hasUser(){
        for (User user : users){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    public static List<User> getAllUser() {

        return new ArrayList<>(users);
    }

    public Optional<User> getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> getByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public void addUser(User user) {
        users.add(user);
    }

}
