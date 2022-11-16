package dev.decagon.fcaebookdemo.serviceImpl;

import dev.decagon.fcaebookdemo.models.Post;
import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.repositories.PostRepository;
import dev.decagon.fcaebookdemo.repositories.UserRepository;
import dev.decagon.fcaebookdemo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pojos.PostRequestDto;
import pojos.PostResponseDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

   private final PostRepository postRepository;
   private final UserRepository userRepository;


    @Override
    public PostResponseDto createNewPost(PostRequestDto postRequestDto, Long id) {

       User user = userRepository.findById(id).get();

       Post post = new Post();
       BeanUtils.copyProperties(postRequestDto, post);
       post.setUser_id(user);

        PostResponseDto postResponseDto = new PostResponseDto();
        BeanUtils.copyProperties(post, postResponseDto);

        postRepository.save(post);

       return postResponseDto;

    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public void editPost(Long id) {



    }


}
