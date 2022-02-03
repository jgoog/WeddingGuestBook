package com.example.weddingguestbook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "photos")

public class Photo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imageContent;

    @Column
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate upload_date;

    @Column
    private String caption;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    public Photo() {
    }

    public Photo(Long id, String imageContent, LocalDate upload_date, String caption) {
        this.id = id;
        this.imageContent = imageContent;
        this.upload_date = upload_date;
        this.caption = caption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageContent() {
        return imageContent;
    }

    public void setImageContent(String imageContent) {
        this.imageContent = imageContent;
    }

    public LocalDate getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(LocalDate upload_date) {
        this.upload_date = upload_date;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
