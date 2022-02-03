package com.example.weddingguestbook.repository;

import com.example.weddingguestbook.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Posts, Long> {
//    Posts findByContent(String postContent);
//    Posts findByIdAndUserId(Long postId, Long userId);


}
