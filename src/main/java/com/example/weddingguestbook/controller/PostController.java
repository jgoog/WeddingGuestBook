package com.example.weddingguestbook.controller;


import com.example.weddingguestbook.model.Comments;
import com.example.weddingguestbook.model.Posts;
import com.example.weddingguestbook.repository.PostRepository;
import com.example.weddingguestbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class PostController {

    private PostService postService;
    private PostRepository postRepository;

    @Autowired
    public void setPostService(PostService postService){
        this.postService = postService;
    }


    @GetMapping(path = "/test-world/")
    public String getHelloWorld(){return "Test World";}

    @GetMapping(path = "/posts/")
    public List<Posts> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping(path = "/posts/")
    public Posts createPost(@RequestBody Posts postObject){
        return postService.createPost(postObject);
    }

    @GetMapping(path = "/posts/{postId}/")
    public Optional<Posts> getPost(@PathVariable Long postId){
        return postService.getPost(postId);
    }

    @PutMapping(path = "/posts/{postId}")
    public Posts updatePost(@PathVariable(value = "postId")Long postID,@RequestBody Posts postObject){
        return postService.updatePost(postID,postObject);
    }

    @DeleteMapping(path = "/posts/{postId}")
    public String deletePost(@PathVariable(value = "postId")Long postId){
        return postService.deletePost(postId);
    }

    @PostMapping(path = "/posts/{postId}/comment")
    public Comments createCommentPost(@PathVariable(value = "postId") Long postId, @RequestBody Comments commentsObject){
        return postService.createCommentPost(postId, commentsObject);
    }

    @GetMapping(path = "/posts/{postId}/comment")
    public List<Comments> getCommentsPost(@PathVariable(value = "postId")Long postId){
        return postService.getCommentsPost(postId);
    }

    @GetMapping(path = "/posts/{postId}/comment/{commentsId}")
    public Comments getCommentPost(@PathVariable(value = "postId")Long postId, @PathVariable(value = "commentsId")Long commentsId){
        return postService.getCommentPost(postId,commentsId);
    }

    @DeleteMapping(path = "/posts/{postId}/comment/{commentsId}")
    public ResponseEntity<HashMap> deleteCommentPost(
            @PathVariable(value = "postId")Long postId, @PathVariable(value = "commentsId")Long commentsId){
        postService.deleteCommentPost(postId,commentsId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "comment with Id: " + commentsId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }



}
