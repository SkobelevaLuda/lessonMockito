package org.example.test;

import org.assertj.core.api.Assertions;
import org.example.repository.UserRepository;
import org.example.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    UserRepository userRepository;

    private User user1 = new User("Login1", "Password1");
    private User user2 = new User("Login2", "Password2");

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    public void emptyList() {
        Collection<User> expected = userRepository.getAllUsers();
        Assertions.assertThat(expected).hasSize(0);
    }

    @Test
    public void getAllUsersList() {
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        Collection<User> expected = userRepository.getAllUsers();
        Collection<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        assertEquals(expected, actual);
    }
    @Test
    public void testUserLogin() {
        userRepository.addUser(user1);
        Optional<User> user1 = userRepository.getByLogin("Login1");
        assertTrue(user1.isPresent());
    }
    @Test
    public void testNonUserLogin() {
        userRepository.addUser(user2);
        Optional<User> user2 = userRepository.getByLogin("Login5");
        assertFalse(user2.isPresent());
    }

    @Test
    public void testUserLoginAndPassword() {
        userRepository.addUser(user1);
        Optional<User> user1 = userRepository.getByLoginAndPassword("Login1", "Password1");
        assertTrue(user1.isPresent());
    }

    @Test
    public void testEqualsPasswordDifferentLogin() {
        userRepository.addUser(user2);
        Optional<User> user2 = userRepository.getByLoginAndPassword("Lolo", "Password2");
        assertTrue(user2.isPresent());
    }
    @Test
    public void testEqualsLoginDifferentPassword() {
        userRepository.addUser(user1);
        Optional<User> user1 = userRepository.getByLoginAndPassword("Login1", "qwerty");
        assertTrue(user1.isPresent());
    }

}
