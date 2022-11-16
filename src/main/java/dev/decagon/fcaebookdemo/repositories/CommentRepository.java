package dev.decagon.fcaebookdemo.repositories;

import dev.decagon.fcaebookdemo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
