package com.example.weddingguestbook.repository;

import com.example.weddingguestbook.model.Posts;
import com.example.weddingguestbook.model.User;
import com.example.weddingguestbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
    UserProfile findByLastNameAndUserId(String lastName, Long userId);

}
