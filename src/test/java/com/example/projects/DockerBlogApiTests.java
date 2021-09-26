package com.example.projects;
import com.example.projects.Repository.UserRepository;
import com.example.projects.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DockerBlogApiTests {
    @Autowired
    private UserRepository userRepository;
    User user1=new User();
    @Test
    void contextLoads() {
        User user = userRepository.save(user1);
    }

}
