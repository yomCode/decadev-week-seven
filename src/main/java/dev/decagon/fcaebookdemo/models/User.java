package dev.decagon.fcaebookdemo.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String dob;


}
