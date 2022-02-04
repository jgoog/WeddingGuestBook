package com.example.weddingguestbook.service;


import com.example.weddingguestbook.exceptions.InformationExistException;
import com.example.weddingguestbook.exceptions.InformationNotFoundException;
import com.example.weddingguestbook.model.Comments;
import com.example.weddingguestbook.model.Photo;
import com.example.weddingguestbook.model.Posts;
import com.example.weddingguestbook.repository.CommentsRepository;
import com.example.weddingguestbook.repository.PhotoRepository;
import com.example.weddingguestbook.repository.PostRepository;
import com.example.weddingguestbook.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    @Autowired
    public void setPostRepository(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    private CommentsRepository commentsRepository;
    @Autowired
    public void setCommentRepository(CommentsRepository commentsRepository){this.commentsRepository = commentsRepository;}

    private PhotoRepository photoRepository;
    @Autowired
    public void setPhotoRepository(PhotoRepository photoRepository){this.photoRepository = photoRepository;}


    public Posts createPost(Posts postObject){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            postObject.setUser(userDetails.getUser());
            return postRepository.save(postObject);
    }
  ////////////////////////             POST                       //////////////////////
    public List<Posts> getAllPosts(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Returning all post by every user");
        List<Posts> posts = postRepository.findByUserId(userDetails.getUser().getId());
        if(posts.isEmpty()){
            throw new InformationNotFoundException("no posts found for user id " + userDetails.getUser().getId() + " not found");
        } else{
            return posts;
        }
    }


    public Optional<Posts> getPost(Long postId){
        Optional<Posts> posts = postRepository.findById(postId);
        if(posts.isPresent()){
            return posts;
        } else{
            throw new InformationNotFoundException("posts with Id " + postId + " not found");
        }
    }

    public Posts updatePost(Long postId,Posts postObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Posts post = postRepository.findByIdAndUserId(postId,userDetails.getUser().getId());
        if (post == null) {
            throw new InformationNotFoundException("post with id " + postId + " not found");
        } else {
            post.setPostContent(postObject.getPostContent());
            return postRepository.save(post);
        }
    }

    public String deletePost (Long postId){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Posts post = postRepository.findByIdAndUserId(postId,userDetails.getUser().getId());
        if (post == null) {
            throw new InformationNotFoundException("post with id " + postId + " not found");
        } else {
            postRepository.deleteById(postId);
            return "post with Id " + postId + " has been deleted successfully";
        }
    }

    //////////////////       COMMENTS API             ///////////////////

    public Comments createCommentPost(Long postId, Comments commentsObject){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Posts post = postRepository.findByIdAndUserId(postId,userDetails.getUser().getId());

        System.out.println("service calling createCommentPost ==>");
        if (post == null) {
            throw new InformationNotFoundException(
                    "post with id " + postId + " does not belongs to this user or post does not exist");
        }
        commentsObject.setUser(userDetails.getUser());
        commentsObject.setPosts(post);
        return commentsRepository.save(commentsObject);
    }

    public List<Comments> getCommentsPost(Long postId){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Posts post = postRepository.findByIdAndUserId(postId,userDetails.getUser().getId());

        System.out.println("Calling all comments on post");
        if (post == null) {
            throw new InformationNotFoundException("post with id " + postId + " " +
                    "not belongs to this user or category does not exist");
        }
        return post.getCommentsList();
    }

    public Comments getCommentPost(Long postId, Long commentsId){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Posts post = postRepository.findByIdAndUserId(postId,userDetails.getUser().getId());
        if (post == null) {
            throw new InformationNotFoundException("post with id " + postId +
                    " not belongs to this user or category does not exist");
        }
        Optional<Comments> comments = commentsRepository.findByPostsId(
                postId).stream().filter(p -> p.getId().equals(commentsId)).findFirst();
        if (!comments.isPresent()) {
            throw new InformationNotFoundException("comment with id " + commentsId +
                    " not belongs to this user or recipe does not exist");
        }
        return comments.get();
    }

    public void deleteCommentPost(Long postId, Long commentsId){
        System.out.println("Calling to delete Comment on post ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Posts post = postRepository.findByIdAndUserId(postId,userDetails.getUser().getId());

        if (post == null) {
            throw new InformationNotFoundException("post with id " + postId +
                    " not belongs to this user or post does not exist");
        }
        Optional<Comments> comments = commentsRepository.findByPostsId(
                postId).stream().filter(p -> p.getId().equals(commentsId)).findFirst();
        if (!comments.isPresent()) {
            throw new InformationNotFoundException("comment with id " + commentsId +
                    " not belongs to this user or comment does not exist");
        }
        commentsRepository.deleteById(comments.get().getId());
    }

    /////////////////////       PHOTO API          //////////////////////////////

    public Photo createPhotoPost(Long postId,Photo photoObject){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Posts post = postRepository.findByIdAndUserId(postId,userDetails.getUser().getId());

        System.out.println("service calling createPhotoPost ==>");
        if (post == null) {
            throw new InformationNotFoundException(
                    "post with id " + postId + " does not belongs to this user or post does not exist");
        }
        photoObject.setUser(userDetails.getUser());
        photoObject.setPosts(post);
        return photoRepository.save(photoObject);
    }

    public List<Photo> getAllPhotosOnPost(Long postId){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Posts post = postRepository.findByIdAndUserId(postId,userDetails.getUser().getId());

        System.out.println("Calling all photos on post");
        if (post == null) {
            throw new InformationNotFoundException("post with id " + postId + " " +
                    "not belongs to this user or category does not exist");
        }
        return post.getPhotoList();
    }

    public Photo getPhotoOnPost(Long postId, Long photoId){
        Optional<Posts> posts = postRepository.findById(postId);
        if (posts.isPresent()) {
            Optional<Photo> photo = photoRepository.findByPostsId(
                    postId).stream().filter(p -> p.getId().equals(photoId)).findFirst();
            if(photo.isEmpty()){
                throw new InformationNotFoundException("Photo with Id " + photoId + " not found");
            }else {
                return photo.get();
            }
        }else{
            throw new InformationNotFoundException("Post with id " + postId + " not found");
        }
    }

    public void deletePhotoPost(Long postId, Long photoId){
        try {
            Photo photo = (photoRepository.findByPostsId(
                    postId).stream().filter(p -> p.getId().equals(photoId)).findFirst()).get();
            photoRepository.deleteById(photo.getId());
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("recipe or category not found");
        }
    }









}



