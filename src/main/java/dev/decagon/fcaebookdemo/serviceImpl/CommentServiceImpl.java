package dev.decagon.fcaebookdemo.serviceImpl;

import dev.decagon.fcaebookdemo.models.Comment;
import dev.decagon.fcaebookdemo.models.Post;
import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.repositories.CommentRepository;
import dev.decagon.fcaebookdemo.repositories.PostRepository;
import dev.decagon.fcaebookdemo.repositories.UserRepository;
import dev.decagon.fcaebookdemo.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pojos.CommentResponseDto;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public CommentResponseDto saveComment(String content, Long user_id, Long post_id) {
        User user = userRepository.findById(user_id).get();
        Post post = postRepository.findById(post_id).get();
        Comment comment = new Comment();
        comment.setUser_id(user);
        comment.setPost_id(post);
        comment.setContent(content);
        commentRepository.save(comment);
        post.getComments().add(comment);

        CommentResponseDto commentResponseDto = new CommentResponseDto();
        BeanUtils.copyProperties(comment, commentResponseDto);




        return commentResponseDto;
    }



}
