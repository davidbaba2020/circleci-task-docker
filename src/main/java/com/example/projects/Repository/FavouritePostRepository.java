package com.example.projects.Repository;

import com.example.projects.model.FavoritePost;
import com.example.projects.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavouritePostRepository extends JpaRepository<FavoritePost, Long> {
    Optional<FavoritePost> findFavoritePostsByFavouritePostId(Long favouritePostId);
}
