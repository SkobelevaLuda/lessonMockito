package org.example.test;


import org.example.repository.UserRepository;
import org.example.user.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepositoryTest {

    private User user1 = new User("Login1", "Password1");
    private User user2 = new User("Login2", "Password2");


    @Test
    public void emptyList() {
        List<User> expected = UserRepository.getAllUsers();
        Assert.assertNotNull(expected);

    }

    @Test
    public void getAllUsersTest() {

        List<User> expected = Collections.singletonList(UserRepository.addUser1(User.getLogin(), User.getPassword()));

        List<User> actual = new ArrayList<>();

        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

}
