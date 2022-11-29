package dev.decagon.fcaebookdemo.models;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String first_name;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(name = "eamil", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "date_of_birth", nullable = false)
    private String dob;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd-hh-mm")
    private LocalDateTime created_At;
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd-hh-mm")
    private LocalDateTime Updated_At;


}
