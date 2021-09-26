package com.example.projects.Service.ServiceImpl;


import com.example.projects.Repository.PostRepository;
import com.example.projects.Repository.UserRepository;
import com.example.projects.Service.PostService;
import com.example.projects.model.Post;
import com.example.projects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    public final PostRepository postRepository;
    public final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post createNewPost(Post post, HttpSession httpSession) {
        Optional<User> user = userRepository.findById(post.getUser().getUserId());
        User userP = new User();
        if(user.isPresent()){
            userP = user.get();
        }
        User userPoster;
        userPoster = (User) httpSession.getAttribute(userP.getEmail());
        if(userPoster!=null){
            //To check active mode else cannot post//
            if(userP.isActivated()!=false){
                post.setUser(userP);
                post.setCreatedDate(Instant.now());
                postRepository.save(post);
            }else{
                System.out.println("Sorry, cannot post because user is not active");
            }
                return post;
            //End of check status
        }else{
            throw new IllegalStateException("User not logged in!");
        }
    }

    @Override
    public Optional<Post> getUsersPosts(Long userId) {
        return postRepository.findById(userId);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
