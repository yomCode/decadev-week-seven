package dev.decagon.fcaebookdemo.repositories;

import dev.decagon.fcaebookdemo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {



}
