package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable; //inform the Java Virtual Machine that this model will be serialized
import java.util.List;
import java.util.Objects;


import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")


public class User {
    @Id //id will be used as the unique identifier
    @GeneratedValue(strategy = GenerationType.AUTO) //id will be a generated value
    private Integer id;
    private String username;
    @Column(unique=true) // value should be unique
    private String email;
    private String password;
    @Transient //signals to Spring Data JPA that this data is NOT to be persisted in the DB
    boolean loggedIn;
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> posts;
    // Need to use FetchType.LAZY to resolve multiple bags exception
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;
    // Need to use FetchType.LAZY to resolve multiple bags exception
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;


}
