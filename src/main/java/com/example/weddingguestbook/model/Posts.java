package com.example.weddingguestbook.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "posts")

public class Posts {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate postDate;

    @Column
    private String postContent;

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
