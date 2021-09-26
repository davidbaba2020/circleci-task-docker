package com.example.projects.Service.ServiceImpl;

import com.example.projects.Repository.PostRepository;
import com.example.projects.Repository.UserRepository;
import com.example.projects.Service.UserService;
import com.example.projects.configurations.TaskThreadCreator;
import com.example.projects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    private ScheduledExecutorService runner;
    private ScheduledFuture<String> deactivatingSchedule;



    @Override
    @Transactional
    public User registerUser(User userRegisterRequest) {
        User newUser1 = User.builder()
                .firstName(userRegisterRequest.getFirstName())
                .lastName(userRegisterRequest.getLastName())
                .email(userRegisterRequest.getEmail())
                .password(userRegisterRequest.getPassword())
                .dateRegistered(Instant.now())
                .activated(true)
                .build();
        System.out.println(newUser1.getFirstName());
        return userRepository.save(newUser1);
    }

    @Override
    public User loginUser(User userLoginRequest, HttpSession httpSession) throws Exception {
        Optional<User> userOptional = userRepository.findUserByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        if (userOptional.isPresent()) {
            userLoginRequest = userOptional.get();
            httpSession.setAttribute(userLoginRequest.getEmail(), userLoginRequest);
            return userLoginRequest;
        } else
            throw new IllegalStateException("Register");
    }


    @Override
    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User deactivateAccount(User user, HttpSession httpSession) throws Exception {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        User nUser = new User();
        if (userOptional.isPresent()) {
            nUser = userOptional.get();
            User loggedInUser;
            loggedInUser = (User) httpSession.getAttribute(nUser.getEmail());
            if (loggedInUser != null) {
                if (nUser.isActivated()) {
                    nUser.setActivated(false);
                    userRepository.saveAndFlush(nUser);
                }
            } else {
                throw new IllegalStateException("User not logged in!");
        }
    }
        return nUser;

}

    @Override
    public User activateAccount(User user, HttpSession httpSession) throws Exception {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        User acUser = new User();
        if (userOptional.isPresent()) {
            acUser = userOptional.get();
            User loggedInUser;
            loggedInUser = (User) httpSession.getAttribute(acUser.getEmail());
            if (loggedInUser != null) {
                if (!acUser.isActivated()) {
                    acUser.setActivated(true);
                    userRepository.saveAndFlush(acUser);
                }
            } else {
                throw new IllegalStateException("User not logged in!");
            }
        }
        return acUser;
    }

    @Override
    public void deleteAccount(User user, HttpSession httpSession) throws Exception {
        User userZone = userRepository.findByEmail(user.getEmail());
        User userOptional = (User) httpSession.getAttribute(userRepository.findUserByUserId(userZone.getUserId()).getEmail());
        User loggedInUser;
        if(userOptional!=null){
            if(userOptional.isActivated()){
                deactivateAccount(userOptional, httpSession);
            }else{
                runner = Executors.newScheduledThreadPool(1);
                LocalDateTime currentTime = LocalDateTime.now();
                LocalDateTime afterTwoMinutes = currentTime.plusMinutes(1);

                Duration periodToTakeBeforeDeleting = Duration.between(currentTime, afterTwoMinutes);
                long delay = Math.abs(periodToTakeBeforeDeleting.toMillis());

                System.out.println("User will be deleted at : "+ LocalDateTime.now().toString().replace("T00:",":"));
                deactivatingSchedule = runner.schedule(new TaskThreadCreator(userZone.getFirstName(),userRepository,userZone), delay, TimeUnit.MILLISECONDS);

            }
        }else{
            throw new IllegalStateException("User not logged in");
        }
    }

}


