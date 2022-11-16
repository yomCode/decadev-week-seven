package dev.decagon.fcaebookdemo.services;

import pojos.CommentResponseDto;


public interface CommentService {

    CommentResponseDto saveComment(String content, Long user_id, Long post_id);

//    List<Comment> getAllComment(Long post_id);


}
