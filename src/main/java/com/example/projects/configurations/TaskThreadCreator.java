package com.example.projects.configurations;

import com.example.projects.Repository.UserRepository;
import com.example.projects.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class TaskThreadCreator implements Callable <String> {
    private final String nameOfThread;
    private final UserRepository userRepository;
    private final User user;


    public TaskThreadCreator(String nameOfThread, UserRepository userRepository, User user) {
        this.nameOfThread = nameOfThread;
        this.userRepository = userRepository;
        this.user = user;
    }

    @Override
    public String call() throws Exception {
        assert  user!=null;
        //user.setActivated(false);
        userRepository.deleteUserByEmail(user.getEmail());
        return "Task [" +nameOfThread+" ] executed on : "+LocalDateTime.now().toString().replace("TOO",":");
    }
}
