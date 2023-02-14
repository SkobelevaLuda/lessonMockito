package org.example.test;

import org.example.exception.UserNonUniqueException;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.user.User;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.NoInteractions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    void testWhenRepositoryReturnsNullThenSomethingHappened() {
        when(userRepository.getAllUsers()).thenReturn(null);
        assertThat(userService.getAllLogins()).isEqualTo(0);
    }

    @Test
    void whenCorrectUserIsAddedThenAddUserIsCalledFromRepository() {
        when(userRepository.getAllUsers()).thenReturn(List.of());
        when(userRepository.addUser(any())).thenReturn(null);
        userService.addNewUser("Login1", "Password1");
        verify(userRepository).addUser(any());
    }
    @Test
    public void whenInvalidUserIsPassedThenServiceThrowsException() {
        assertThatThrownBy(() -> userService.addNewUser("", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Пользователь должен быть определен!");
        verify(userRepository, new NoInteractions()).getAllUsers();
        verify(userRepository, new NoInteractions()).addUser(any());
    }
    @Test
    void whenExistingUserIsPassedThenServiceThrowsException() {
        when(userRepository.getAllUsers()).thenReturn(List.of(new User("Login2", "Password2")));
        assertThatThrownBy(() -> userService.addNewUser("Login2", "Password2"))
                .isInstanceOf(UserNonUniqueException.class)
                .hasMessage("Пользователь не уникален!");
    }
    @Test
    void whenNetworkExceptionIsRaisedThenServiceReturnsZero() {
        when(userRepository.getAllUsers()).thenThrow(new RuntimeException());
        assertThat(userService.getAllLogins()).isEqualTo(0);
    }


}
