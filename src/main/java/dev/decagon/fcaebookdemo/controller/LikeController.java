package dev.decagon.fcaebookdemo.controller;


import dev.decagon.fcaebookdemo.models.User;
import dev.decagon.fcaebookdemo.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/saveComment")
    public String saveLike(@RequestParam(value = "post_id") Long post_id, HttpSession session){
        User user = (User) session.getAttribute("currUser");

        likeService.saveLike(post_id, user.getId());

        return "redirect:/feeds";
    }


    @PostMapping("/deleteComment")
    public String deleteComment(@RequestParam(value="like_id") Long like_id){

        likeService.deleteLike(like_id);

        return "redirect:/feeds";
    }


}
