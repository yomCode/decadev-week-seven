package dev.decagon.fcaebookdemo.services;

import dev.decagon.fcaebookdemo.models.Like;

public interface LikeService {

    Like saveLike(Long post_id, Long user_id);
    void deleteLike(Long like_id);
}
