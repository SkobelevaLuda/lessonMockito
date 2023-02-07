package org.example.service;

import org.example.exception.UserNonUniqueException;
import org.example.repository.UserRepository;
import org.example.user.User;

import java.util.List;


public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginOfUsers(){


        return List<User>
    }

    public void addNewUser(String login, String passvord){
        User user = new User(login,passvord);
        if (login==null||login.isBlank()){
            throw new IllegalArgumentException("Неверное значение логина");
        }
        if (passvord==null||passvord.isBlank()){
            throw new IllegalArgumentException("Неверное значение пароля");
        }
        boolean userExist= this.userRepository
                .getAllUser().stream()
                .allMatch(u->u.equals(user));
        if(userExist){
            throw new UserNonUniqueException();
        }else {
            this.userRepository.addUser(user);
        }
    }
}
