package dev.decagon.fcaebookdemo.repositories;


import dev.decagon.fcaebookdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);
}
