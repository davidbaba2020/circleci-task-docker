package com.example.projects.Repository;

import com.example.projects.model.PostLikeAndDislike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeAndDislikeRepository extends JpaRepository<PostLikeAndDislike, Long> {
}
