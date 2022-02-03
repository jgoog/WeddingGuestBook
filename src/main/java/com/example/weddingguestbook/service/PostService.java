package com.example.weddingguestbook.service;


import com.example.weddingguestbook.exceptions.InformationExistException;
import com.example.weddingguestbook.exceptions.InformationNotFoundException;
import com.example.weddingguestbook.model.Comments;
import com.example.weddingguestbook.model.Posts;
//import com.example.weddingguestbook.repository.CommentRepository;
import com.example.weddingguestbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
//    private CommentRepository commentRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository){
        this.postRepository = postRepository;
    }

//    @Autowired
//    public void setCommentRepository(CommentRepository commentRepository){this.commentRepository = commentRepository;}


//    public List<Posts> getAllPosts(){
//        List<Posts> posts = postRepository.findBy
//    }


    public Posts createPost(Posts postObject){

            return postRepository.save(postObject);
    }

    public List<Posts> getAllPosts(){
        System.out.println("Returning all post by every user");
        return postRepository.findAll();
    }


    public Optional<Posts> getPost(Long postId){
        Optional<Posts> posts = postRepository.findById(postId);
        return posts;
    }

//    public Posts updatePost(Long postId,Posts postObject) {
//
//        Optional<Posts> post = postRepository.findById(postId);
//        if (post.isPresent()) {
//            if (postObject.getPostContent().equals(post.get().getPostContent())) {
//                System.out.println("Same info try again");
//                throw new InformationExistException("post " + post.get().getPostContent() + " already exists");
//            } else {
//                Posts updatePost = postRepository.findById(postId).get();
////                updatePost.setPostDate(postObject.getPostDate());
//                updatePost.setPostContent(postObject.getPostContent());
//                return postRepository.save(updatePost);
//            }
//        }else {
//            throw new InformationNotFoundException("post with id " + postId + " does not exist");
//        }
//    }

        public String deletePost (Long postId){
            postRepository.deleteById(postId);
            return "post with Id " + postId + "has been deleted successfully";
        }

//        public Comments createCommentPost(Long postId, Comments commentsObject){
//            System.out.println("service calling createCategoryRecipe ==>");
//            try {
//                Optional post = postRepository.findById(postId);
//                commentsObject.setPosts((Posts) post.get());
//                return (Comments) commentRepository.save(commentsObject);
//            } catch (NoSuchElementException e) {
//                throw new InformationNotFoundException("post with id " + postId + " not found");
//            }
//        }















}



