package com.example.projects.Service.ServiceImpl;

import com.example.projects.Repository.CommentRepository;
import com.example.projects.Repository.PostRepository;
import com.example.projects.Repository.UserRepository;
import com.example.projects.Service.CommentService;
import com.example.projects.model.Comments;
import com.example.projects.model.Post;
import com.example.projects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Comment createPostComment(Comments comments, HttpSession httpSession) {
        Optional<User> user = userRepository.findById(comments.getUser().getUserId());
        User userP = new User();
        if (user.isPresent()) {
            userP = user.get();
        }
            User userPC = new User();
            userPC = (User) httpSession.getAttribute(userPC.getEmail());
            if (userPC != null) {
                Post commentPost = new Post();
                Optional<Post> post = postRepository.findById(comments.getPost().getPostId());
                if (post.isPresent()) {
                    commentPost = post.get();
                    comments.setUser(userP);
                    comments.setCommentedDate(Instant.now());
                    commentRepository.save(comments);
                    postRepository.save(commentPost);
                    return (Comment) comments;
                } else {
                    throw new IllegalStateException("Not post located");
                }
            } else {
                throw new IllegalStateException("User Not logged in");
            }
        }

    @Override
    public List<Comments> getAllUserComments(Long userId) {
        User user = (User) userRepository.findAll();
        Optional<Comments> allByUser = null;
        if(user !=null){
            allByUser = commentRepository.findAllByUser(user);
        }else{
                new IllegalStateException(user.getEmail() + "Not found");
        }
        return  allByUser.stream().toList();
    }


    @Override
    public List<Comments> getAllComments() {
        return commentRepository.findAll();
    }
}