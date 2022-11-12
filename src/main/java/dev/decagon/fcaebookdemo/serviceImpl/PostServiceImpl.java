package dev.decagon.fcaebookdemo.serviceImpl;

import dev.decagon.fcaebookdemo.models.Post;
import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.repositories.PostRepository;
import dev.decagon.fcaebookdemo.repositories.UserRepository;
import dev.decagon.fcaebookdemo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pojos.PostRequestDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

   private final PostRepository postRepository;
   private final UserRepository userRepository;


    @Override
    public Post createNewPost(PostRequestDto postRequestDto, Long id) {

       User user = userRepository.findById(id).get();

       Post post = new Post();
       BeanUtils.copyProperties(postRequestDto, post);
       post.setUser_id(user);

       return postRepository.save(post);

    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }


}
