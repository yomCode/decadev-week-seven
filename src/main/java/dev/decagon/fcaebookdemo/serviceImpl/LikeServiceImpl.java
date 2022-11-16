package dev.decagon.fcaebookdemo.serviceImpl;

import dev.decagon.fcaebookdemo.models.Like;
import dev.decagon.fcaebookdemo.models.Post;
import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.repositories.LikeRepository;
import dev.decagon.fcaebookdemo.repositories.PostRepository;
import dev.decagon.fcaebookdemo.repositories.UserRepository;
import dev.decagon.fcaebookdemo.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Override
    public Like saveLike(Long post_id, Long user_id) {
        Post post = postRepository.findById(post_id).get();
        User user = userRepository.findById(user_id).get();
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);

        return likeRepository.save(like);
    }

    @Override
    public void deleteLike(Long like_id) {
//        Post post = postRepository.findById(post_id).get();
//        User user = userRepository.findById(user_id).get();

//        Like like = new Like();
//        like.setId(like_id);
//        like.setPost(post);
//        like.setUser(user);


        likeRepository.deleteById(like_id);

    }


}
