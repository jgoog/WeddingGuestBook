package com.example.weddingguestbook.model;
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
