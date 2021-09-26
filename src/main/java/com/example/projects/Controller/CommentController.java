package com.example.projects.Controller;

import com.example.projects.Service.CommentService;
import com.example.projects.model.Comments;
import com.example.projects.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/comment/")
public class CommentController {

        public final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

        @PostMapping("createPostComment")
        public Post create_new_post_comment(@RequestBody Comments comments, HttpSession httpSession){
            return (Post) commentService.createPostComment(comments, httpSession);
        }

        @GetMapping("all_comments")
        public List<Comments> getAllPost(){
            return commentService.getAllComments();
        }

        @GetMapping("all_comments_by_user")
        public List<Comments> getAllCommentsByUser(@RequestBody Long userId){
            return commentService.getAllUserComments(userId);
        }



    }
