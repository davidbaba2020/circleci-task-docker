package com.example.projects.Service.ServiceImpl;

import com.example.projects.Repository.UserRepository;
import com.example.projects.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {


    @MockBean
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void registerUser() throws Exception {
//        List<Comments> comments = null;
//        List<Post> post = null;
//        List<User> friend = null;
//        Map<Long, String> favoritePosts;
        User user2= User.builder()
                .userId(2L)
                .firstName("Daniel")
                .lastName("B")
                .email("daniel@gmail.com")
                .password("12345")
                .dateRegistered(Instant.now())
                .build();

        User user3= User.builder()
                .userId(1L)
                .firstName("David")
                .lastName("B")
                .email("david@gmail.com")
                .password("12345")
                .dateRegistered(Instant.now())
                .build();
//        when(userRepository.save(user3)).thenReturn(user3);
        when(userRepository.save(any())).thenReturn(user3);
        assertEquals(user3, userService.registerUser(user3));
    }

    @Test
    void loginUser() {
    }

    @Test
    public void getAllUsers() throws Exception {

        User user= User.builder()
                .firstName("Mary")
                .lastName("Bulus")
                .email("mary@gmail.com")
                .password("12345")
                .dateRegistered(Instant.now())
                .activated(true)
                .build();
        User user2= User.builder()
                .firstName("Tobi")
                .lastName("Mark")
                .email("tobi@gmail.com")
                .password("12345")
                .dateRegistered(Instant.now())
                .activated(true)
                .build();
    when(userRepository.findAll()).thenReturn((List<User>) Stream.of (user, user2).collect(Collectors.toList()));
    assertEquals(2, userService.getAllUsers().size());

    }
    @Test
    void deactivateAccount() {
    }

    @Test
    void activateAccount() {
    }
}