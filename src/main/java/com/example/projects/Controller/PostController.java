package com.example.projects.Controller;

import com.example.projects.Service.PostService;
import com.example.projects.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/post/")
public class PostController {

    public final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("createPost")
    public Post create_new_post(@RequestBody Post post, HttpSession httpSession){
        return postService.createNewPost(post, httpSession);
    }

    @GetMapping("all")
    public List<Post> get_all_post(){
        return postService.findAll();
    }

}
