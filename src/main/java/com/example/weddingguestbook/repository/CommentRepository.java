package com.example.weddingguestbook.repository;

import com.example.weddingguestbook.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Long> {



}
