package com.example.weddingguestbook.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "profiles")
public class UserProfile {



    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String relation;

    // Connect to user table
    @JsonIgnore // will not be included in serialized Json object,won't show up when called upon
    @OneToOne(mappedBy = "userProfile")
    private User user;

    public UserProfile() {
    }

    public UserProfile(Long id, String lastName, String firstName, String relation) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.relation = relation;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
