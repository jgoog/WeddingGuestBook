package com.example.weddingguestbook.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")

public class Posts {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    private LocalDate postDate;

    @Column
    private String postContent;

    @OneToMany(mappedBy = "posts", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comments> commentsList;

    @OneToMany(mappedBy = "posts",orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Photo> photoList;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;


    public Posts() {
    }

    public Posts(Long id, LocalDate postDate, String postContent) {
        this.id = id;
        this.postDate = postDate;
        this.postContent = postContent;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", postDate=" + postDate +
                ", postContent='" + postContent + '\'' +
                '}';
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
