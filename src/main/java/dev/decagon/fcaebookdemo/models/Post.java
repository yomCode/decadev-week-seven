package dev.decagon.fcaebookdemo.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;

    private Long userId;
    private Timestamp creation_dateTime;
    private String post_text;

//    private List<Comment> comments;
//    private List<Like> likes;
}
