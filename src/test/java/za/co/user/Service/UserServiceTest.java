package za.co.user.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.co.user.Domain.User;
import za.co.user.Repository.UserRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User.Builder()
                .setEmail("test@example.com")
                .setName("John")
                .setSurname("Doe")
                .setPassword("password123")
                .setDob(LocalDate.of(1990, 1, 1))
                .setGender("Male")
                .setPhone("1234567890")
                .setAddress("123 Main St")
                .build();
    }

    @Test
    void testSaveUser() {
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        User savedUser = userService.save(user);

        assertNotNull(savedUser);
        assertEquals("test@example.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testUpdateUser() {
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        User updatedUser = userService.update(user);

        assertNotNull(updatedUser);
        assertEquals("John", updatedUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteById() {
        doNothing().when(userRepository).deleteById("test@example.com");

        userService.deleteById("test@example.com");

        verify(userRepository, times(1)).deleteById("test@example.com");
    }

    @Test
    void testGetByIdFound() {
        when(userRepository.findById("test@example.com")).thenReturn(Optional.of(user));

        User foundUser = userService.getById("test@example.com");

        assertNotNull(foundUser);
        assertEquals("John", foundUser.getName());
        verify(userRepository, times(1)).findById("test@example.com");
    }

    @Test
    void testGetByIdNotFound() {
        when(userRepository.findById("unknown@example.com")).thenReturn(Optional.empty());

        User foundUser = userService.getById("unknown@example.com");

        assertNull(foundUser);
        verify(userRepository, times(1)).findById("unknown@example.com");
    }

    @Test
    void testGetAll() {
        List<User> userList = Arrays.asList(user);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> allUsers = userService.getAll();

        assertFalse(allUsers.isEmpty());
        assertEquals(1, allUsers.size());
        verify(userRepository, times(1)).findAll();
    }
}
