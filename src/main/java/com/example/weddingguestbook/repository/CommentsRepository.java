package com.example.weddingguestbook.repository;

import com.example.weddingguestbook.model.Comments;
import com.example.weddingguestbook.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
//    List<Comments> findByPostId(Long commentsId);
    List<Comments> findByPostsId(Long commentId);
    Comments findByIdAndUserId(Long postId, Long userId);
}
