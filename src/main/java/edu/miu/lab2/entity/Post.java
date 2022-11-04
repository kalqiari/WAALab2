package edu.miu.lab2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long id;
     String title;
     String content;
     String author;
     @ManyToOne
     User user;
     @OneToMany
     List<Comment> comments;
}

