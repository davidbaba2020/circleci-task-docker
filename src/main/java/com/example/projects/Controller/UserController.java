package com.example.projects.Controller;

import com.example.projects.Service.UserService;
import com.example.projects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create_user")
    public User signUpUser(@RequestBody User user) throws Exception{
        return userService.registerUser(user);
    }


    @GetMapping("allUsers")
    public List<User> getAllUsers() throws Exception{
        return userService.getAllUsers();
    }

    @PostMapping("deactivateAccount")
    public User deactivateUser(@RequestBody User user, HttpSession http) throws Exception{
        return userService.deactivateAccount(user, http);
    }

    @PostMapping("activateAccount")
    public User activateUser(@RequestBody User user, HttpSession http) throws Exception{
        return userService.activateAccount(user,http);
    }

    @PostMapping("login")
    public User loginUser(@RequestBody User user, HttpSession session) throws Exception{
        return userService.loginUser(user, session);
    }

    @PostMapping("deleteAccount")
    public void deleteUserAccount(@RequestBody User user, HttpSession http) throws Exception{
        userService.deleteAccount(user, http);
    }
}
