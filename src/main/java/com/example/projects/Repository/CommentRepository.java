package com.example.projects.Repository;

import com.example.projects.model.Comments;
import com.example.projects.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long>  {

    Optional<Comments> findAllByUser(User user);
}
