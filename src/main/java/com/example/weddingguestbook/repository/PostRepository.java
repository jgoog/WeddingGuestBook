package com.example.weddingguestbook.repository;

import com.example.weddingguestbook.model.Posts;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository  extends JpaRepository<Posts, Long> {
//    Posts findByContent(String postContent);
    Posts findByIdAndUserId(Long postId, Long userId);
    List<Posts> findByUserId(Long userId);
    Posts findByUserIdAndPostContent(Long userId,String postContent);


}
