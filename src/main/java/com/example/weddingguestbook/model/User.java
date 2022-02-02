package com.example.weddingguestbook.model;



import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

//    @Column
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private String password;

    @Column(unique = true)
    private String email;


    public User() {
    }

//    public User(Long id, String userName, String password, String email) {
//        this.id = id;
//        this.userName = userName;
//        this.password = password;
//        this.email = email;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
