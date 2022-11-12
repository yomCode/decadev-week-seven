package dev.decagon.fcaebookdemo.services;

import dev.decagon.fcaebookdemo.models.Post;
import pojos.PostRequestDto;

import java.util.List;

public interface PostService {

    Post createNewPost(PostRequestDto postDto, Long id);

    List<Post> getAllPost();

}
