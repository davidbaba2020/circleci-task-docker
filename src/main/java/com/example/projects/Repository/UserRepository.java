package com.example.projects.Repository;


import com.example.projects.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmailAndPassword(String email, String password);
    Optional<User>findUserByEmail(String email);
    User findByEmail(String email);
    User findUserByUserId(Long id);
    User deleteUserByEmail(String email);
}
;