package dev.decagon.fcaebookdemo.services;

import dev.decagon.fcaebookdemo.models.Post;
import pojos.PostRequestDto;
import pojos.PostResponseDto;
import java.util.List;

public interface PostService {

    PostResponseDto createNewPost(PostRequestDto postDto, Long id);

    List<Post> getAllPost();

    void deletePost(Long id);

    void editPost(Long id);

}
