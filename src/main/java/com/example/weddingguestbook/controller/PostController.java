package com.example.weddingguestbook.controller;


import com.example.weddingguestbook.model.Comments;
import com.example.weddingguestbook.model.Posts;
import com.example.weddingguestbook.repository.PostRepository;
import com.example.weddingguestbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @PutMapping(path = "/posts/{postId}")
//    public Posts updatePost(@PathVariable(value = "postId")Long postID,@RequestBody Posts postObject){
//        return postService.updatePost(postID,postObject);
//    }

    @DeleteMapping(path = "/posts/{postId}")
    public String deletePost(@PathVariable(value = "postId")Long postId){
        return postService.deletePost(postId);
    }

//    @PostMapping(path = "/posts/{postId}")
//    public Comments createCommentPost(@PathVariable(value = "postId") Long postId, @RequestBody Comments commentsObject){
//        return postService.createCommentPost(postId, commentsObject);
//    }




}
