package com.example.projects.Service;

import com.example.projects.model.Comments;
import com.example.projects.model.Post;

import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;
import java.util.List;

public interface CommentService {
     Comment createPostComment(Comments comments, HttpSession httpSession);
     List<Comments> getAllUserComments(Long userId);
     List<Comments> getAllComments();
}
