package com.example.projects.Service;

import com.example.projects.model.Post;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


public interface PostService {
    Post createNewPost(Post post, HttpSession session);
   Optional<Post> getUsersPosts(Long userId);
    List<Post> findAll();
}
