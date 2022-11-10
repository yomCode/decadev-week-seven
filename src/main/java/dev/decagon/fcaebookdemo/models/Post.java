package dev.decagon.fcaebookdemo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String post_content;
    @ManyToOne
    @JoinColumn(name = "user_id_id")
    private User user_id;


}
