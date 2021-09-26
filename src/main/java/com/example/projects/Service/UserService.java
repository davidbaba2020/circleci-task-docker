package com.example.projects.Service;


import com.example.projects.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface UserService {
    User registerUser(User userRegisterRequest) throws Exception;
//    User registerUser(User user) throws Exception;
//    User loginUser(User user, HttpSession httpSession) throws Exception;
    User loginUser(User userLoginRequest, HttpSession httpSession) throws Exception;
    List<User>  getAllUsers() throws Exception;
    User deactivateAccount(User user, HttpSession httpSession) throws Exception;
    User activateAccount(User user, HttpSession httpSession) throws Exception;
    void deleteAccount(User user, HttpSession httpSession) throws Exception;

}
