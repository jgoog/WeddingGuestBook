package com.example.weddingguestbook.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "comments")

public class Comments {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comment;

    //Connect to posts table
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;

    // Connect to user table
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;


    public Comments() {
    }

    public Comments(Long id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
