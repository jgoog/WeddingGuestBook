package com.example.weddingguestbook.repository;


import com.example.weddingguestbook.model.User;
import com.example.weddingguestbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // to register
    boolean existsByEmailAddress(String userEmailAddress);

    //to login
    User findUserByEmailAddress(String email);

//    User findByIdAndUserId(Long Id, Long userId);
}
