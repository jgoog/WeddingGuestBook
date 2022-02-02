package com.example.weddingguestbook.model;
import javax.persistence.*;


@Entity
@Table(name = "user_profile")
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


    public UserProfile() {
    }

    public UserProfile(Long id, String lastName, String firstName, String relation) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.relation = relation;
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
