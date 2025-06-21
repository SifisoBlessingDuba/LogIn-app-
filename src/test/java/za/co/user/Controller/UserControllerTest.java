package za.co.user.Controller;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import za.co.user.Domain.User;
import za.co.user.Service.UserService;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testSave() throws Exception {
        User user = new User.Builder()
            .setEmail("test@example.com")
            .setName("Test User")
                .build();

        when(userService.save(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/home/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.name").value("Test User"));

        verify(userService, times(1)).save(any(User.class));
    }

    @Test
    void testUpdate() throws Exception {
        User user = new User.Builder()
            .setEmail("test@example.com")
            .setName("Updated User")
                .build();

        when(userService.update(any(User.class))).thenReturn(user);

        mockMvc.perform(put("/home/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.name").value("Updated User"));

        verify(userService, times(1)).update(any(User.class));
    }

    @Test
    void testFindById() throws Exception {
        User user = new User.Builder()
            .setEmail("test@example.com")
            .setName("Test User")
            .build();

        when(userService.getById("test@example.com")).thenReturn(user);

        mockMvc.perform(get("/home/findById/{email}", "test@example.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.name").value("Test User"));

        verify(userService, times(1)).getById("test@example.com");
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(userService).deleteById("test@example.com");

        mockMvc.perform(delete("/home/delete/{email}", "test@example.com"))
                .andExpect(status().isOk());

        verify(userService, times(1)).deleteById("test@example.com");
    }

    @Test
    void testGetAll() throws Exception {
        User user1 = new User.Builder()
            .setEmail("test1@example.com")
            .setName("User One")
                .build();

        User user2 = new User.Builder()
            .setEmail("test2@example.com")
            .setName("User Two")
                .build();


        List<User> users = Arrays.asList(user1, user2);

        when(userService.getAll()).thenReturn(users);

        mockMvc.perform(get("/home/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(users.size()))
                .andExpect(jsonPath("$[0].email").value("test1@example.com"))
                .andExpect(jsonPath("$[1].email").value("test2@example.com"));

        verify(userService, times(1)).getAll();
    }
}
