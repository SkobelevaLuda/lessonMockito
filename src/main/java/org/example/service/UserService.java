package org.example.service;

import org.example.exception.UserNonUniqueException;
import org.example.repository.UserRepository;
import org.example.user.User;


public class UserService {

    private UserRepository userRepository;
    private User user;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String loginOfUsers(){
        return userRepository.getByLogin(User.getLogin());
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
