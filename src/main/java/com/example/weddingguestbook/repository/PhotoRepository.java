package com.example.weddingguestbook.repository;

import com.example.weddingguestbook.model.Comments;
import com.example.weddingguestbook.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {

    List<Photo> findByPostsId(Long commentId);

}
